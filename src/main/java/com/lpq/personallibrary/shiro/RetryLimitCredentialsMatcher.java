package com.lpq.personallibrary.shiro;

import com.lpq.personallibrary.util.PasswordHashUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher implements InitializingBean{
    private static final Logger logger=LogManager.getLogger(LibraryShiroRealm.class);
    @Autowired
    private PasswordHashUtils passwordHashUtils;
    @Autowired
    private CacheManager cacheManager;

    private Cache<String,AtomicInteger> passwordRetryCache;

    @Override
    public void afterPropertiesSet() throws Exception {
        super.setHashAlgorithmName(passwordHashUtils.getAlgorithmName());
        super.setHashIterations(passwordHashUtils.getHashIterations());
        this.passwordRetryCache=cacheManager.getCache("halfHour");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        String username=(String)token.getPrincipal();
        AtomicInteger retryCount=passwordRetryCache.get(username);
        if(retryCount==null){
            retryCount=new AtomicInteger(1);
            passwordRetryCache.put(username,retryCount);
        }
        if(retryCount.getAndIncrement()>3){
            logger.warn("username: " + username + " tried to login more than 5 times in period");
            throw new ExcessiveAttemptsException("密码输入错误超过3次,用户锁定半小时,请稍后重试!");
        }else{
            passwordRetryCache.put(username,retryCount);
        }
        boolean match=super.doCredentialsMatch(token,info);
        if(match){
            passwordRetryCache.remove(username);
        }
        return match;
    }
}
