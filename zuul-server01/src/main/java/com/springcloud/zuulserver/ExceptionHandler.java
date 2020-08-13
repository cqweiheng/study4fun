package com.springcloud.zuulserver;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandler implements ErrorController {

	/**
	 * 返回处理限流异常的路径
	 * @return java.lang.String
	 * @date 2020/8/2 18:45
	 * @author wei.heng
	 */
	@Override
	public String getErrorPath() {
		return "error";
	}

	/**
	 *
	 * 自定义方法对异常进行处理
	 * @return java.lang.String
	 * @date 2020/8/2 18:46
	 * @author wei.heng
	 */
	@RequestMapping("/error")
	public String error() {
		return "{\"result\":\"访问太多频繁，请稍后再访问！！！\"}";
	}

}
