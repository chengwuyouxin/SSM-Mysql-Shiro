package com.lpq.personallibrary.controller;


import com.lpq.personallibrary.common.Result;
import org.apache.log4j.Logger;

public abstract class BaseController {
    protected Logger logger=Logger.getLogger(BaseController.class.getName());


    public Result renderSuccess(){
        Result result=new Result();
        result.setSuccess(true);
        return result;
    }

    public Result renderError(String msg){
        Result result=new Result();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }
}
