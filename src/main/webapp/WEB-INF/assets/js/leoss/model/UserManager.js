define('leoss/model/UserManager', function(require, exports, module) {
    var self = null;
    var Util = require("leoss/util");
    var UserManager = function(){
        self = this;
        this.DATA_MAP = {};
        this.regUrl = "/reg";
        this.loginUrl = "/portal";
        this.keyCreateUrl =  l_path+'/api/key/create';
        this.keyDeleteUrl =  l_path+'/api/key/delete';
        this.keyStatusUrl =  l_path+'/api/key/status/set';
        this.keyListUrl =  l_path+'/api/key/list';
    }

    UserManager.prototype = {
        setLoginName:function(loginName){
            this.DATA_MAP.login_name = loginName;
        },
        submit:function(){
            Util.post(this.regUrl,this.DATA_MAP,this.successSubmit,this.errorSubmit);
        },
        loginDataInit:function(loginName,password,verify){
            this.DATA_MAP.loginName = loginName;
            this.DATA_MAP.password = password;
            this.DATA_MAP.verify = verify;
        },
        signinSubmit:function(successCallback,errorCallback){
            Util.post(this.loginUrl,this.DATA_MAP,successCallback,errorCallback);
        },
        successSubmit:function(json){
            alert(json);
        },
        errorSubmit:function(obj){
            alert("error");
        },
        keylist:function(_callBack){
            Util.get(this.keyListUrl,this.DATA_MAP,_callBack,self.errorCallBack);
        },
        createKey:function(csrf,_callBack){
        	this.DATA_MAP._csrf = csrf;
            Util.post(this.keyCreateUrl,this.DATA_MAP,_callBack,self.errorCallBack);
        },
        deleteKey:function(id,csrf,_callBack){
        	this.DATA_MAP._csrf = csrf;
        	this.DATA_MAP.key_id = id;
        	Util.post(this.keyDeleteUrl,this.DATA_MAP,_callBack,self.errorCallBack);
        },
        setKeyStatus:function(id,status,csrf,_callBack){
        	this.DATA_MAP._csrf = csrf;
        	this.DATA_MAP.key_id = id;
            this.DATA_MAP.status = status;
        	Util.post(this.keyStatusUrl,this.DATA_MAP,_callBack,self.errorCallBack);
        },
        errorCallBack:function(json){
        	alert("error");
        }
    }

    module.exports = new UserManager();
});
