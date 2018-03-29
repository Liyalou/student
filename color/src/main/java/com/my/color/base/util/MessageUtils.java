package com.my.color.base.util;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.common.Constant;

public class MessageUtils {

	public static void getMessage(RedirectAttributes attributes,Integer type){
		if(type == 1){
			attributes.addFlashAttribute(Constant.ALERT_TYPE, Constant.ALERT_SUCCESS);
			attributes.addFlashAttribute(Constant.ALERT_MSG, "操作成功");
		}else{
			attributes.addFlashAttribute(Constant.ALERT_TYPE, Constant.ALERT_DANGER);
			attributes.addFlashAttribute(Constant.ALERT_MSG, "操作失败");
		}
	}
}
