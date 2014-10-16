define('leoss/signin', function(require, exports, module) {
    var $ = require('jquery');
    var UserManager = require('leoss/model/UserManager');
    var util = require("leoss/util");
    var errCount = 0;
    var self = null;
    var signin = function(){
        self = this;
    }

    signin.prototype = {
        init:function(){
            $(function(){
                self.bindClick();
            })
        },
        bindClick:function(){
            $("#loginForm").on("submit",function(){
            	return self.checkForm();
            });
            $('#validate_img').click(function(){
            	util.flushCaptcha("validate_img");
            })
        },
        checkForm:function(){
            return this.loginNameCheck($("#login_name").val())&&
                this.passwordCheck($('#password').val())&&
                this.verifyCheck($("#verify").val());
        },
        loginNameCheck:function(login_name){
            if(login_name == ''){
                alert('邮箱不能为空');
                return false;
            }
            return true;
        },
        passwordCheck:function(password){
            if(password == ''){
                alert('密码不能为空');
                return false;
            }
            return true;
        },
        verifyCheck:function(verify){
            if(verify == ''){
                alert('验证码不能为空');
                return false;
            }
            return true;
        },
        singinSubmit:function(login_name,password,verify){
            UserManager.loginDataInit(login_name, password,verify);
            UserManager.signinSubmit(self._successCallBack,self._errorCallback);
        },
        _successCallBack:function(){
          alert("成功");
        },
        _errorCallback: function(ret){
            if (ret.code == 403) {
                if(ret.data.code == "bad captcha"){
                    alert('验证码错误')
                    $('#verify').focus();
                    return false;
                }else{
                    location.href ="/leoss_portal/user/signin";
                }
            } else if (ret.code != 200) {
                if (++errCount >= 3) {
                    alert('密码错误');
                }
                $('#password').focus();
                return false;
            } else {
                $.cookie('LB_N', $('#login_name').val(),  {expires: 365});
                location.href = "/";
            }
        }
    }
    module.exports = new signin();
});
