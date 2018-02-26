package com.lpq.personallibrary.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 校验验证码
 */
@Component
public class ValidateUtils {
	private final static Logger logger = LogManager.getLogger(ValidateUtils.class);
	private final static String Verification_Code_Attribute_Name ="VeriCode";

	private String veriAttribute;

	public ValidateUtils() {
		this.veriAttribute=Verification_Code_Attribute_Name;
	}

	public String getVeriAttribute() {
		return veriAttribute;
	}

	public void setVeriAttribute(String veriAttribute) {
		this.veriAttribute = veriAttribute;
	}

	/**
	 * 生成验证码
	 */
	public void generate(HttpServletRequest request, HttpServletResponse response) {
		String verificationCode=CaptchaUtils.generateCode().toUpperCase();// 转成大写重要

		request.getSession().setAttribute(this.veriAttribute,verificationCode);

		CaptchaUtils.generate(response, verificationCode);
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param userInputCaptcha 用户输入的验证码
	 * @return 验证通过返回 true, 否则返回 false
	 */
	public boolean validate(HttpServletRequest request, HttpServletResponse response, String userInputCaptcha) {
		if (logger.isDebugEnabled()) {
			logger.debug("validate captcha userInputCaptcha is " + userInputCaptcha);
		}
		Object vCode=request.getSession().getAttribute(this.veriAttribute);
		if(vCode==null) return false;
		String verificationCode=vCode.toString().toUpperCase();
		// 转成大写重要
		userInputCaptcha = userInputCaptcha.toUpperCase();
		boolean result = userInputCaptcha.equals(verificationCode);
		return result;
	}
}
