package hu.okfonok.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;

/**
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component
@Scope("singleton")
public class Config implements ApplicationContextAware{
	private static Config instance;
	
	@Value("${root}")
	private String root;
	
	@Value("${supportEmail}")
	private String supportEmail;
	
	
	public static String getSupportEmail() {
		return instance.supportEmail;
	}
	
	public static String getUserProfilePath() {
		return instance.root + "/users";
	}
	
	public static String getUserProfileContext() {
		return "/users";
	}
	
	public static String getStaticContextPath() {
		return instance.root + "/static";
	}
	
	public static String getEmailTemplatePath() {
		return instance.root + "/email";
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		instance = applicationContext.getBean(Config.class);
	}
}
