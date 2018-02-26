$(document).ready(function() {
    $("#captcha").click(function(){
        var $this=$(this);
        var url= $this.data("src")+ new Date().getTime();
        $this.attr("src",url);
    })

    $("#login").click(function(){
        var username=$("#username").val();
        var password=$("#password").val();
        var captcha=$("#captcha").val();
        if(!$("#username").val()){
            alert("请输入用户名!");
            return;
        }
        if(!$("#password").val()){
            alert("请输入密码!")
            return;
        }
        if(!$("#inputcaptcha").val()){
            alert("请输入验证码!");
            return;
        }
        $.ajax({
            url:"login",
            type:'post',
            dataType:'json',
            data:$("#loginform").serialize(),
            success:function(result){
                if(result.success){
                    window.location.href="index";
                }else{
                    alert(result.msg);
                    $("#captcha").click();
                }
            }
        })
    })

    $("#register").click(function(){
        $.ajax({
            url:"register",
            type:"post",
            dataType:'json',
            data:$("#registerform").serialize(),
            success:function(result){
                if(result.success){
                    window.location.href="login";
                }else{
                    alert(result.msg);
                }
            }
        })
    })
});
