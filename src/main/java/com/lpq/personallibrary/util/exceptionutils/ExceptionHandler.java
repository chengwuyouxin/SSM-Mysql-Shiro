package com.lpq.personallibrary.util.exceptionutils;

import com.lpq.personallibrary.controller.BaseController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lpq.personallibrary.common.Result;

@ControllerAdvice
public class ExceptionHandler extends BaseController{
    //该注释指明LibraryException在此方法中进行处理
    @org.springframework.web.bind.annotation.ExceptionHandler(LibraryException.class)
    public @ResponseBody Result libraryExceptionHandler(LibraryException ex){
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.getModel().put("exception",ex);
//        modelAndView.setViewName("library_error");
//        return modelAndView;
        return renderError(ex.getMessage());
    }
    //注解中指明Exception.class，所以前面未能匹配的异常进入此方法进行处理
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public  @ResponseBody Result allExceptionHanlder(Exception ex){
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.getModel().put("exception",ex);
//        modelAndView.setViewName("error");
//        return modelAndView;
        return renderError(ex.getMessage());
    }
}
