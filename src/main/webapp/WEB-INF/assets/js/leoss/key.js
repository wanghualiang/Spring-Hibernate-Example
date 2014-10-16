define('leoss/key', function(require, exports, module) {
    var $ = require('jquery');
    var UserManager = require('leoss/model/UserManager');
    var self = null;
    var keys = function(){
        self = this;
    }

    keys.prototype = {
        init: function () {
            $(function () {
                self.keylist();
            })
        },
        setKeyStatus: function (id,status,csrf) {
            UserManager.setKeyStatus(id, status,csrf,self.statusCallBack);
        },
        deleteKey: function (id,csrf) {
            UserManager.deleteKey(id,csrf,self.deleteCallBack);
        },
        createKey: function (csrf) {
            UserManager.createKey(csrf,self.createCallBack);
        },
        keylist:function(){
            UserManager.keylist(self.listCallBack);
        },
        bindEnableClick:function(){
        	$(".deleteBtn").unbind("click");
        	$(".enableBtn").unbind("click");
        	$(".disableBtn").unbind("click");
        	$(".createbtn").unbind("click");
            $(".deleteBtn").on("click", function () {
            	if(confirm('注意：正在进行的操作为删除密钥。确认删除吗？') ){
                	var id=$(this).parent().parent().parent().find("td[class='key-ctime']").find("#id").val();
                	return self.deleteKey(id,$("#_csrf").val());
                }
            	return false;
            });
            $(".createbtn").on("click", function () {
                return self.createKey($("#_csrf").val());;
            });
            $(".enableBtn").on("click", function () {
            	var id=$(this).parent().parent().parent().find("td[class='key-ctime']").find("#id").val();
            	return self.setKeyStatus(id,1,$("#_csrf").val());
            });
            $(".disableBtn").on("click", function () {
            	if(confirm('注意：正在进行的操作为禁用密钥。确认禁用吗？') ){
                	var id=$(this).parent().parent().parent().find("td[class='key-ctime']").find("#id").val();
                	return self.setKeyStatus(id,0,$("#_csrf").val());
                }
            	return false;
            });
        },
        listCallBack:function(json){
        	$(".key-line").remove();
        	if(json.length > 0){
        		for(var i in json){
        			var tr = $("#key-list-tr").clone();
        			var ctime = new Date(parseInt(json[i].ctime));
        			var year=ctime.getFullYear();
        			var month=ctime.getMonth()+1;
        			var day=ctime.getDate();
        			var date= year+"/"+month+"/"+day;  
        			$(tr).find("td[class='key-ctime']").find("#id").attr('value',json[i].id);
        			$(tr).find("td[class='key-ctime']").find("#status").attr('value',json[i].status);
        			$(tr).find("td[class='key-ctime']").find("#ctime").html(date);
        			$(tr).find("td[class='key-input']").find("#access_key").attr('value',json[i].accessKey);
        			$(tr).find("td[class='key-input']").find("#secret_key").attr('value',json[i].secretKey);
        			if(json[i].status == 1){
        				$(tr).find("td[class='key-status']").find("#statusstop").remove();
        				$(tr).find("#btnstop").remove();
        			}else{
        				$(tr).find("td[class='key-status']").find("#statususe").remove();
        				$(tr).find("#btnuse").remove();
        			}
        			$('tbody').append('<tr class="key-line">'+tr.html()+"</tr>");
        			if(json.length>=2){
        				$(".newkeys").hide();
        			}else{
        				$(".newkeys").show();
        			}
        		}
        	}
        	self.bindEnableClick();
        },
        createCallBack:function(json){
			if(json.result == 'ok'){
			}else{
				alert("error");
			}
        	self.keylist();
        },
        deleteCallBack:function(json){
			if(json.result == 'ok'){
			}else{
				alert("error");
			}
        	self.keylist();
        },
        statusCallBack:function(json){
			if(json.result == 'ok'){
			}else{
				alert("error");
			}
        	self.keylist();
        }
    }
    module.exports = new keys();
});
