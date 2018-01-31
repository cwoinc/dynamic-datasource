package com.wantdo.datasource;

import java.lang.annotation.*;

/**
 * 
 * @ClassName: TargetDataSource 
 * @Description: TODO
 * @author leepon1990
 * @date 2016年4月18日 下午5:42:20 
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface TargetDataSource {
	String value();
}
