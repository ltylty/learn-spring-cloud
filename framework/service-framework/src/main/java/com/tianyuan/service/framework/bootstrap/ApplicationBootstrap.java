package com.tianyuan.service.framework.bootstrap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tianyuan.service.framework.EnableServiceFramework;

/**
 * 微服务springboot应用的启动引导类
 * @author leon_liu@enable-ets.com
 * @since 2017/4/26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableServiceFramework
public class ApplicationBootstrap extends WebMvcConfigurerAdapter {
	
	@ControllerAdvice
	public static class GlobalExceptionHandler {
		/**
		 * 默认错误页面
		 */
	    public static final String DEFAULT_ERROR_VIEW = "error";
	    
	    @ExceptionHandler(value = Exception.class)
	    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("referer", req.getHeader("referer"));
	        mav.addObject("exception", e);
	        req.getHeaderNames();
	        mav.addObject("url", req.getRequestURL());
	        mav.setViewName(DEFAULT_ERROR_VIEW);
	        return mav;
	    }
	}
	
	/**
	 * 定制化servlet 容器
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

	    return new EmbeddedServletContainerCustomizer() {
	        @Override
	        public void customize(ConfigurableEmbeddedServletContainer container) {

	            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
	            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");

	            container.addErrorPages(error401Page, error404Page);
	        }
	    };
	}
}
