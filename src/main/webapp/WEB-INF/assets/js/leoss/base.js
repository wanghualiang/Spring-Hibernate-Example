define('leoss/base', function(require, exports, module) {
    var $ = require('jquery');
    var util = require('leoss/util');
    var self = null;
    var base = function(){
        self = this;
    }
    base.prototype = {
        init:function(){
            this.bindClick();
            this.initFormData();
        },
        bindClick:function(){
            $("#i-edit").on("click",this.reloadPage);
            $('#i-cancel').on("click",this.returnPage);
            $("#i-save").on("click",this.baseInfoSubmit);
        },
        reloadPage:function(){
            $('#i-edit').hide();
            $("#i-save").show();
            $("#i-cancel").show();
            $("#companyType-Val").hide();
            $("#companyType").show();
            $('.i-unedit').addClass('i-edit').prop("disabled",false).removeClass('i-unedit');
        },
        returnPage:function(){
            $("#i-save").hide();
            $("#i-cancel").hide();
            $('#i-edit').show();
            $("#companyType-Val").show();
            $("#companyType").hide();
            $('.i-edit').addClass('i-unedit').prop("disabled",true).removeClass('i-edit');
            self.initFormData();
        },
        initFormData:function(){
        	$("#baseForm")[0].reset();
        },
        baseInfoSubmit:function(){
        	if(self.checkSubmit()){
        		$("#baseForm").submit();        		
        	}
        },
        checkSubmit:function(){
        	return true;
        }
    };

    module.exports = base;
});
