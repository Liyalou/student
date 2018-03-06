$ (function ()
{
	$("#findpwd").click(function(){
		$("#fwd-input").removeData("bs.modal");
		$("#fwd-input").load(ctx+"/fwd",function(){
			$("#fwd-input").modal({
				backdrop:'static',
				show:true
			});
		});
	});
	$("#menuhelp").click(function(){
		sweetAlert("帮助","");
	});
	$("#about").click(function(){
		sweetAlert("帮助","");
	});
	$("#help").click(function(){
		sweetAlert("帮助","");
	});
	$.ajaxSetup (
	{
		cache : false
	});
	
	$ (".top-menu li a").click (function ()
	{
		$ (".top-menu li a.selected").removeClass ("selected");
		$ (this).addClass ("selected");
	});
	
	var cookie_openMenuId = $.cookies.get ("openMenuId");
	
	if (!cookie_openMenuId)
	{
		$.cookies.set ("openMenuId", "");
	}
	
	var cookie_activeMenuId = $.cookies.get ("activeMenuId");
	
	if (!cookie_activeMenuId)
	{
		$.cookies.set ("activeMenuId", "");
	}
	
	var cookie_level3 = $.cookies.get ("level3");
	
	if (!cookie_level3)
	{
		$.cookies.set ("level3", "");
	}
	
	var cookie_level4 = $.cookies.get ("level4");
	
	if (!cookie_level4)
	{
		$.cookies.set ("level4", "");
	}
	
	var levelParentId = $ ("#" + cookie_level3).closest ("ul").closest ("li").attr ("id");
	
	var level4ParentId = $ ("#" + cookie_level4).closest ("ul").closest ("li").attr ("id");
	
		if(level4ParentId == cookie_level3 && levelParentId == cookie_activeMenuId)
		{
			$ ("#" + cookie_level4).addClass ("active");
			$ ("#" + cookie_level3).addClass ("active open");
			$ ("#" + cookie_level3).find ("ul").css ("display", "");
			$ ("#" + cookie_activeMenuId).addClass ("active open");
			$ ("#" + cookie_activeMenuId).find ("ul").css ("display", "");
			$ ("#" + cookie_openMenuId).addClass ("active open");
			$ ("#" + cookie_openMenuId).find ("ul").css ("display", "");
		}else if (levelParentId == cookie_activeMenuId)
		{
			$ ("#" + cookie_level3).addClass ("active");
			$ ("#" + cookie_activeMenuId).addClass ("active open");
			$ ("#" + cookie_activeMenuId).find ("ul").css ("display", "");
			$ ("#" + cookie_openMenuId).addClass ("active open");
			$ ("#" + cookie_openMenuId).find ("ul").css ("display", "");
		}
		else
		{
			$ ("#" + cookie_activeMenuId).addClass ("active");
			$ ("#" + cookie_openMenuId).addClass ("active open");
			$ ("#" + cookie_openMenuId).find ("ul").css ("display", "");
		}
	
	
	$ ("#egov-menu li").click (function ()
	{
		var menuId = $ (this).attr ("id");
		var level = $ (this).attr ("class");
		
		if ($ (this).hasClass ("level_1"))
		{
			$.cookies.set ("openMenuId", $ (this).attr ("id"));
		}
		
		if ($ (this).hasClass ("level_2"))
		{
			$.cookies.set ("activeMenuId", $ (this).attr ("id"));
		}
		
		if ($ (this).hasClass ("level_3"))
		{
			$.cookies.set ("level3", $ (this).attr ("id"));
		}
		
		if ($ (this).hasClass ("level_4"))
		{
			$.cookies.set ("level4", $ (this).attr ("id"));
		}
		
	});
})

