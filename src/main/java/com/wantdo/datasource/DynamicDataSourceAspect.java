package com.wantdo.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order(-1) // 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

	// private final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

	@Before("execution(* com.wantdo.mapper.*.*(..))")
	public void before(JoinPoint point) {
		Object target = point.getTarget();
		String method = point.getSignature().getName();

		Class<?>[] classz = target.getClass().getInterfaces();

		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
		try {
			Method m = classz[0].getMethod(method, parameterTypes);
			if (m != null && m.isAnnotationPresent(TargetDataSource.class)) {
				TargetDataSource data = m.getAnnotation(TargetDataSource.class);
				DynamicDataSourceContextHolder.setDataSourceType(data.value());
				// logger.info("DataSource：" + data.value());
				System.out.println("DataSource：" + data.value());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After("execution(* com.wantdo.mapper.*.*(..))")
	public void restoreDataSource(JoinPoint point) {
		DynamicDataSourceContextHolder.clearDataSourceType();
	}
}
