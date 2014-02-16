package hu.okfonok.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Ács Ádám
 *
 */
@Service
@Scope("application")
public class ServiceLocator implements ApplicationContextAware{
	private static ApplicationContext springContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ServiceLocator.springContext = applicationContext;
	}
	
	public static <T> T getBean(Class<T> requiredType) {
		return springContext.getBean(requiredType);
	}
}
