package com.lpq.personallibrary.controller;

import com.lpq.personallibrary.common.Result;
import com.lpq.personallibrary.entity.User;
import com.lpq.personallibrary.service.UserService;
import com.lpq.personallibrary.util.PasswordHashUtils;
import com.lpq.personallibrary.util.ValidateUtils;
import com.lpq.personallibrary.util.exceptionutils.LibraryException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController extends BaseController{

    @Autowired
    private ValidateUtils validateUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordHashUtils passwordHashUtils;

    @RequestMapping(value={"/","/login"}, method= RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public @ResponseBody
    Result login(HttpServletRequest request, HttpServletResponse response,
                 String username, String password, String captcha,
                 @RequestParam(value = "rememberMe",required=false,defaultValue = "0") Integer rememberMe) throws Exception {
        boolean remember=false;
        if(!validateUtils.validate(request,response,captcha)){
            throw new LibraryException("验证码输入错误!");
        }
        try{
            if(rememberMe==1) remember=true;
            UsernamePasswordToken token=new UsernamePasswordToken(username,password,remember);
            Subject user= SecurityUtils.getSubject();
            user.login(token);
            return renderSuccess();
        }catch(Exception ex){
            if(ex instanceof ExcessiveAttemptsException)
            {
                throw new LibraryException(ex.getMessage());
            }else {
                throw new LibraryException("用户名或密码错误！");
            }
        }
    }

    @RequestMapping(value="/captcha",method=RequestMethod.GET)
    public void getVerficationCode(HttpServletRequest request, HttpServletResponse response){
        validateUtils.generate(request,response);
    }

    @RequestMapping(value="/unauthorized")
    private String unauthorized(){
        return "unauthorized";
    }

    @RequestMapping(value="/logout")
    public String logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index";
    }

    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public @ResponseBody Result registerform(String username, String password,String repeatpassword){
        String salt=new SecureRandomNumberGenerator().nextBytes().toHex();
        String encodePassword=passwordHashUtils.toHash(password,salt);
        User user=new User(username,encodePassword,salt);
        try{
            userService.createUser(user);
            return renderSuccess();
        }catch(Exception ex){
            return renderError(ex.getMessage());
        }
    }
}
