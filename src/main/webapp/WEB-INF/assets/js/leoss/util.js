define('leoss/util', function(require, exports, module){
    var $ = require('jquery');
    exports.post = function(url,data,successCallback,errorCallback){
        $.ajax({
            type:'post',
            url:url,
            data:data,
            dataType:'json',
            success:successCallback,
            error:errorCallback
        });
    };
    exports.get = function(url,data,successCallback,errorCallback){
        $.ajax({
            type:'get',
            url:url,
            data:data,
            dataType:'json',
            success:successCallback,
            error:errorCallback
        });
    };
    exports.postSync = function(url,data,successCallback,errorCallback){
        $.ajax({
            type:'post',
            async:false,
            url:url,
            data:data,
            dataType:'json',
            success:successCallback,
            error:errorCallback
        });
    };
    exports.getSync = function(url,data,successCallback,errorCallback){
        $.ajax({
            type:'get',
            async:false,
            url:url,
            data:data,
            dataType:'json',
            success:successCallback,
            error:errorCallback
        });
    };
    exports.flushCaptcha = function(id){
    	var src = $("#"+id).attr("src");
        src = src.split("?");
        src = src[0] + "?"+Math.random();
        $("#"+id).attr("src",src);
    };
});
