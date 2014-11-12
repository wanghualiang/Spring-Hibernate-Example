var l_path = location.href.indexOf("/Spring-Hibernate-Example") >= 0 ? '/Spring-Hibernate-Example' : '';
seajs.config({
	base: "/",
	paths: {
		'leoss'   : l_path+'/assets/js/leoss',
        'gallery' : l_path+'/assets/js/gallery'
	},
	alias: {
		'jquery'     : 'gallery/jquery/jquery/1.10.2/jquery.js',
		'mustache'   : 'gallery/mustache/0.7.2/mustache.js',
		'i18n'       : 'gallery/i18n/jquery.i18n.properties-1.0.9.js',
		'jqunit'     : 'gallery/qunit/1.12.0/qunit.js',
		'cookie'     : 'gallery/jquery/cookie/1.3.1/jquery.cookie.js',
		'Clipboard'  : 'gallery/ZeroClipboard/ZeroClipboard.js',
		'jqtree'     : 'gallery/jquery/jqtree/tree.jquery.js',
		'spin'       : 'gallery/jquery/spin/jquery-spin.js',
		'i18n'       : 'gallery/i18n/jquery.i18n.properties-1.0.9.js'
	},
    preload: ['jquery'],
	debug: false,
	charset: 'utf-8'
});


seajs.use(['jquery', 'i18n', 'cookie'], function($){

    var language = $.cookie('language');
	jQuery.i18n.properties({
		name: 'strings',        // 资源文件名称
		path: l_path+'/assets/resource/i18n/', // 资源文件所在文件夹路径
		//mode: 'both',           // 模式：变量或 Map
		mode: 'map',           // 模式：变量或 Map
		language: language?language:'zh',      // 对应的语言
		cache: false,
		encoding: 'UTF-8',
		callback: function() {// 回调方法
		}
	});
});
