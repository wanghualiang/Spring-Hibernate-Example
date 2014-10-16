define('leoss/signup', function(require, exports, module) {
    var $ = require('jquery');
    var UserManager = require('leoss/model/UserManager');
    var util = require('leoss/util');
    var self = null;
    var signup = function(){
        self = this;
    }
    signup.prototype = {
        init:function(){
            $(function(){
                self.bindEvent();
            })

        },
        bindEvent:function(){
            $('#leoss_regist').on('submit',function(){
            	
            	return self.checkForm();
            });
            $('#validate_btn').on("click",self.flushImg);
            $("#validate_img").on("click",self.flushImg);
        },
        checkForm:function(){
            return this.checkEmail($('#email').val()) &&
                this.checkPassword($('#pwd').val(),$('#cpwd').val()) &&
                this.checkLoginName($('#loginName').val()) &&
                this.checkContactName($('#contactName').val()) &&
                this.checkPhone($('#phone').val()) &&
                this.checkCompanyType($("#companyType").val())&&
                this.checkCompanyName($('#companyName').val()) &&
                this.checkCompanySite($('#companySite').val()) &&
                this.checkValidate($('#validate').val());
        },
        checkEmail:function(email){
            if(email == ''){
                alert("邮箱不能为空");
                return false;
            }
            return true;
        },
        checkPassword:function(pwd,cpwd){
            if(pwd == ""){
                alert("密码不能为空");
                return false;
            }else if(cpwd == ''){
                alert("确认密码不能为空");
                return false;
            }else if(pwd != cpwd){
                alert("两次密码不相同");
                return false;
            }
            return true;
        },
        checkLoginName:function(loginName){
            if(loginName == ''){
                alert("登录名称不能为空");
                return false;
            }
            return true;
        },
        checkContactName:function(contactName){
            if(contactName == ''){
                alert("联系人不能为空");
                return false;
            }
            return true;
        },
        checkPhone:function(phone){
            var regx = new RegExp(/^1\d{10}$/);
            if(phone == ""){
                alert("手机号码不能为空");
                return false;
            }else if(!regx.test(phone)){
                alert("手机号码格式错误");
                return false;
            }
            return true;
        },
        checkCompanyType:function(type){
            try{
                type = parseInt(type);
                if(type == -1){
                    alert("请选择企业类型");
                    return false;
                }
            }catch(e){
                alert("请选择企业类型");
                return false;
            }
            return true;
        },
        checkCompanyName:function(companyName){
            if(companyName == ""){
                alert("公司/个人名称不能为空");
                return false;
            }
            return true;
        },
        checkCompanySite:function(companySite){
            if(companySite == ""){
                alert("公司/个人主页不能为空");
                return false;
            }
            return true;
        },
        checkValidate:function(validate){
            if(validate == ""){
                alert("验证码不能为空");
                return false;
            }
            return true;
        },
        flushImg:function(){
        	util.flushCaptcha('validate_img');
        }
    }
    module.exports= new signup();
});
