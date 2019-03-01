package cn.cj.service.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import cn.cj.tools.Constant;

/**
 * 对权限不足的页面进行拦截处理
 * @author chenjie
 *
 */
@ControllerAdvice
public class AuthorExceptionHandler {

	@ExceptionHandler({UnauthorizedException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ModelAndView processUnauthentcatedException(NativeWebRequest request,UnauthorizedException e){
		return new ModelAndView("error",Constant.AUTHOR_EXCEPTION,e);
	}
}
