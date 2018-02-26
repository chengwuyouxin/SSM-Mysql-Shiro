package com.lpq.personallibrary.util;

import org.apache.shiro.crypto.hash.SimpleHash;


public class PasswordHashUtils {
    private String algorithmName;
    private int hashIterations;

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public int getHashIterations() {
        return hashIterations;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public  String toHash(Object source,Object salt){
        SimpleHash hash=new SimpleHash(algorithmName,source,salt,hashIterations);
        return hash.toHex();
    }
}
