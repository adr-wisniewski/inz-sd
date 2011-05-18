(function($) {
    $.fn.collapsible_menu = function(options) {
        options = $.extend({
            cookieName: 'collapsibleMenu',
            cookiePath: '/',
            delimeter: '|',
            cssClass: 'collapsed'
        }, options);

        var getCookie = function()
        {
            var cookie = $.cookie(options.cookieName);

            if(!cookie)
                return [];
           
            return cookie.split(options.delimeter);
        }

        var setCookie = function(arr)
        {
            $.cookie(
                options.cookieName,
                arr.join(options.delimeter),
                {
                    path: options.cookiePath
                }
            );
        }

        var setExpanded = function(element, id, value)
        {
            var cookie = getCookie();
            var index = $.inArray(id, cookie);
            var expaned = (index != -1);

            if(value)
            {
                $(element).removeClass(options.cssClass);
                $(element).next().slideDown();
                
                if(!expaned)
                {
                    cookie.push(id);
                    setCookie(cookie);
                }
               
            }
            else 
            {
                $(element).addClass(options.cssClass);
                $(element).next().slideUp();

                if(expaned)
                {
                    cookie.splice(index, 1);
                    setCookie(cookie);
                }
            }
        }


        var handleClick = function(e)
        {
            setExpanded(this, $(this).parent().attr('id'), $(this).hasClass(options.cssClass));
        };

        var init = function()
        {
            if($.inArray($(this).parent().attr('id'), getCookie()) == -1) {
                $(this).addClass(options.cssClass);
                $(this).next().hide();
            }
                
        };

        $(".collapsible", this).click(handleClick).each(init);
        
        return this;
    }
})(jQuery);