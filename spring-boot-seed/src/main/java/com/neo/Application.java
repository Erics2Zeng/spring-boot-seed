package com.neo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import tk.mybatis.mapper.autoconfigure.MapperProperties;
import tk.mybatis.mapper.code.Style;

@SpringBootApplication
@MapperScan("com.neo.mapper")
public class Application implements ApplicationContextAware {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//			System.out.println("-------"+beanName);
//		}
		MapperProperties mapperProperties = (MapperProperties) applicationContext.getBean("mapper-tk.mybatis.mapper.autoconfigure.MapperProperties");
		Style st = mapperProperties.getStyle();
		mapperProperties.setStyle(Style.normal);
		System.out.println("----style--"+ st.name());
	}

}
