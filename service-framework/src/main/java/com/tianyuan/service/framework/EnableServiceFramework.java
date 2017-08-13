package com.tianyuan.service.framework;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.tianyuan.service.framework.dao.datasource.DruidAutoConfiguration;

@Target({ java.lang.annotation.ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({EnableServiceFrameworkConfiguration.class, DruidAutoConfiguration.class})
public @interface EnableServiceFramework {
	
}