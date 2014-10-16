/*----------------------------------------------------------------------------
 * jQuery Clipboard Copy
 * ---------------------------------------------------------------------------
 * jQuery:  1.2.x compatible
 * Keyword: copy,clipboard,copy all,jquery copy, jquery selector copy
 *
 * Author:  Stephen Blum
 *
 * Files:   jquery.copy.js          ## Source
 *          jquery.copy.examples.js ## Example Usage
 *          jquery.copy.min.js      ## Minified JS
 *          jquery.copy.swf         ## Flash SWF
 *          minify.pl               ## Perl JS Minifier 
 *                                  ## ./minify.pl jquery.copy.js > min.js
 *          jquery-1.2.5.min.js     ## Standard jQuery Library
 *
 * Summary: Cross-browser text copy plugin usable in the jQuery dot notation
 *          fashion $("#elmID").copy(). This plugin will copy all text inside
 *          the matching jQuery selector. There exists another implementation
 *          of this idea, however it seems a bit complex.  This plugin is
 *          much easier to use and works with jQuery's famous chains and
 *          selectors.
 * 
 * ---------------------------------------------------------------------------
 * USAGE TYPE 1: Basic (Simply copy text inside a div to the Clipboard)
 * ---------------------------------------------------------------------------
 * $("div#my-div-id").copy();
 *
 * ---------------------------------------------------------------------------
 * USAGE TYPE 2: Delimiter (Copy Multiple items with a Delimiter)
 * ---------------------------------------------------------------------------
 * $("input.copy-class").copy('\n');
 *
 * ---------------------------------------------------------------------------
 * USAGE TYPE 3: Utility (Copy JS Variable)
 * ---------------------------------------------------------------------------
 * var my_string = "text";
 * $.copy(my_string);
 *
 * ---------------------------------------------------------------------------
 * EXAMPLE 1: Copy text from a DIV on button click event.
 * ---------------------------------------------------------------------------
 * // Copy all text inside "div#my-div-element-id" div.
 * $("input#my-button-id").bind( 'click', function() {
 *     $("div#my-div-element-id").copy(); 
 * });
 *
 * ---------------------------------------------------------------------------
 * EXAMPLE 2: Copy all INPUT elements inside a form on button click.
 * ---------------------------------------------------------------------------
 * // Copy all textboxes inside "#my-div-form-id".
 * $("input#my-button-id").bind( 'click', function() {
 *     $("form#my-form-id input").copy(); 
 * });
 *----------------------------------------------------------------------------
 */
 ;define(function(require, exports){
    var $= jQuery = require('jquery');

    /*
    jquery.flash v1.3.1 -  02/01/10
    (c)2009 Stephen Belanger - MIT/GPL.
    http://docs.jquery.com/License
    */
    Array.prototype.indexOf = function(o, i) {
        for (var j = this.length, i = i < 0 ? i + j < 0 ? 0 : i + j: i || 0; i < j && this[i] !== o; i++);
        return j <= i ? -1 : i;
    };
    $.fn.extend({
        flash: function(opt) {
            var has, cv, ie;
            function attr(a, b) {
                return ' ' + a + '="' + b + '"';
            }
            function param(a, b) {
                return '<param name="' + a + '" value="' + b + '" />';
            }
            var p = navigator.plugins;
            if (p && p.length) {
                var f = p['Shockwave Flash'];
                if (f) {
                    has = true;
                    if (f.description) cv = f.description.replace(/([a-zA-Z]|\s)+/, "").replace(/(\s+r|\s+b[0-9]+)/, ".").split(".");
                }
                if (p['Shockwave Flash 2.0']) {
                    has = true;
                    cv = '2.0.0.11';
                }
            } else {
                try {
                    var axo = new ActiveXObject("ShockwaveFlash.ShockwaveFlash.7");
                } catch(e) {
                    try {
                        var axo = new ActiveXObject("ShockwaveFlash.ShockwaveFlash.6");
                        cv = [6, 0, 21];
                        has = true;
                    } catch(e) {};
                    try {
                        axo = new ActiveXObject("ShockwaveFlash.ShockwaveFlash");
                    } catch(e) {};
                }
                if (axo != null) {
                    cv = axo.GetVariable("$version").split(" ")[1].split(",");
                    has = true;
                    ie = true;
                }
            }
            $(this).each(function() {
                if (has) {
                    var e = $(this),
                    s = $.extend({
                        'id': e.attr('id'),
                        'class': e.attr('class'),
                        'width': e.width(),
                        'height': e.height(),
                        'src': e.attr('href'),
                        'classid': 'clsid:D27CDB6E-AE6D-11cf-96B8-444553540000',
                        'pluginspace': 'http://get.adobe.com/flashplayer',
                        'availattrs': ['id', 'class', 'width', 'height', 'src'],
                        'availparams': ['src', 'bgcolor', 'quality', 'allowscriptaccess', 'allowfullscreen', 'flashvars', 'wmode'],
                        'version': '9.0.24'
                    },
                    opt),
                    a = s.availattrs,
                    b = s.availparams,
                    rv = s.version.split('.'),
                    o = '<object';
                    if (!s.codebase) {
                        s.codebase = 'http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=' + rv.join(',');
                    }
                    if (s.express) {
                        for (var i in cv) {
                            if (parseInt(cv[i]) > parseInt(rv[i])) {
                                break;
                            }
                            if (parseInt(cv[i]) < parseInt(rv[i])) {
                                s.src = s.express;
                            }
                        }
                    }
                    if (s.flashvars) {
                        s.flashvars = unescape($.param(s.flashvars));
                    }
                    a = ie ? a.concat(['classid', 'codebase']) : a.concat(['pluginspage']);
                    for (k in a) {
                        var n = (k == a.indexOf('src')) ? 'data': a[k];
                        o += s[a[k]] ? attr(n, s[a[k]]) : '';
                    };
                    o += '>';
                    for (k in b) {
                        var n = (k == b.indexOf('src')) ? 'movie': b[k];
                        o += s[b[k]] ? param(n, s[b[k]]) : '';
                    };
                    o += '</object>';
                    e.html(o);
                }
                return this;
            });
        }
    });    
    jQuery.copy = function(data) { return jQuery.fn.copy.call({}, data); };
    jQuery.fn.copy = function(delimiter) {
        // Get Previous Object List
        var self = this,

        // Capture or Create Div for SWF Object
        flashcopier = (function(fid) {
            return document.getElementById(fid) || (function() {
                var divnode    = document.createElement('div');
                    divnode.id = fid;
                document.body.appendChild(divnode);
                return divnode;
            })();
        })('_flash_copier'),

        // Capture our jQuery Selected Data and Scrub
        data = jQuery.map(self, function(bit) {
            return typeof bit === 'object' ? bit.value ||
                          bit.innerHTML.replace(/<.+>/g, '') : '';
        }).join( delimiter || '' ).replace(/^\s+|\s+$/g, '') || delimiter;

        // Define SWF Object with our Captured Data
        //divinfo = '<object type="application/x-shockwave-flash" data="/js/gallery/jquery/copy/jquery.copy.swf" width="0px" height="0px"><param name="wmode" value="window"><param name="movie" value="/js/gallery/jquery/copy/jquery.copy.swf"><param name="quality" value="high"><param name="menu" value="false"><param name="allowScriptAccess" value="always"><param name="FlashVars" value="'+ encodeURIComponent(data) + '"></object>'; 
        /*
        divinfo = '<embed src="/js/gallery/jquery/copy/jquery.copy.swf" FlashVars="clipboard='
                + encodeURIComponent(data)
                + '" width="0" height="0" '
                + 'type="application/x-shockwave-flash"></embed>';
        */

        // Create SWF Object with Defined Data Above

        var flashDiv = $('<div></div>');
        flashDiv.flash({
            'src':'/js/gallery/jquery/copy/jquery.copy.swf',
            'width':'100',
            'height':'100',
            'allowscriptaccess':'always',
            'flashvars': {
                'clipboard': encodeURIComponent(data)
            }
        });
        $(flashcopier).empty().append(flashDiv);
        
        // Return Previous Object List
        return self;
    };
});
