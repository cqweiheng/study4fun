package com.springcloud.zuulserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @date 2020/8/2 17:58
 * @author wei.heng
 */
public class PermissionFilter extends ZuulFilter {

	/**
	 * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
	 * 这里定义为pre，代表会在请求被路由之前执行。
	 * @return java.lang.String
	 * @date 2020/8/2 17:33
	 * @author wei.heng
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * filter执行顺序，通过数字指定。
	 * 数字越大，优先级越低。
	 * @return int
	 * @date 2020/8/2 17:34
	 * @author wei.heng
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * filter 开启关闭
	 * 判断该过滤器是否需要被执行。这里我们直接返回了true，
	 * 因此该过滤器对所有请求都会生效。
	 * 实际运用中我们可以利用该函数来指定过滤器的有效范围。
	 * @return boolean
	 * @date 2020/8/2 17:35
	 * @author wei.heng
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的具体逻辑
	 * @return java.lang.Object
	 * @date 2020/8/2 17:36
	 * @author wei.heng
	 */
	@Override
	public Object run() throws ZuulException {
		//获得HttpServletRequest对象
		RequestContext cc = RequestContext.getCurrentContext();
		HttpServletRequest request = cc.getRequest();
		//获得HttpServletResponse对象
		HttpServletResponse response = cc.getResponse();
		//获得客户端提交的Token进行验证
		String token=request.getParameter("token");

//		if(StringUtils.isEmpty(token) || !token.equals("123456")) {
//			//不对该请求进行路由，不会将请求转发到后端
//			cc.setSendZuulResponse(false);
//			//设置错误状态码
//			cc.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//			//设置响应体,也可以将响应的数据封装为json串进行响应
//			cc.setResponseBody("权限不足.....");
//			response.setContentType("text/html;charset=UTF-8");
//			//设置响应头信息
//			//cc.addZuulRequestHeader("Content-Type",
//			//MediaType.TEXT_HTML_VALUE+";charset=UTF-8");
//			//ZuulFilterResult
//		}
		return null;

	}
}
