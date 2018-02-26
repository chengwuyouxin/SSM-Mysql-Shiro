package com.lpq.personallibrary.shiro;

import com.lpq.personallibrary.entity.User;
import com.lpq.personallibrary.service.UserService;
import com.lpq.personallibrary.util.exceptionutils.LibraryException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

public class LibraryShiroRealm extends AuthorizingRealm{

    private static final Logger logger=LogManager.getLogger(LibraryShiroRealm.class);

    @Autowired
    private UserService userService;

    public LibraryShiroRealm(CredentialsMatcher credentialsMatcher){
        super(credentialsMatcher);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("登录认证开始");
        String username=(String)authenticationToken.getPrincipal();
        User user=userService.findUserByUsername(username);
        if(user==null){
            new LibraryException("无效的用户名!");
        }
        return new SimpleAuthenticationInfo(user.getUsername(),user.getPwd(),
                ByteSource.Util.bytes(user.getSalt()),getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("Shiro登录授权开始");
        String username=(String)principalCollection.getPrimaryPrincipal();
        Set<String> roles=new HashSet<String>();
        Set<String> permissions=new HashSet<String>();
        roles=userService.findRoles(username);
        permissions=userService.findPermissions(username);
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);
        info.setStringPermissions(permissions);
        return info;
    }
}
