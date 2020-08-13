package com.example.springboot;

import com.example.springboot.aspect.MyAspect;
import com.example.springboot.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan(
	basePackages = "com.example.springboot",	// 指定扫描的包
//	sqlSessionTemplateRef = "sqlSessionTemplate",
	annotationClass = Repository.class	// 通过注解作加载类限定
)
public class SpringbootApplication {

	@Bean(name="myAspect")
	public MyAspect initMyAspect(){
		return new MyAspect();
	}

	@Autowired
	ApplicationContext applicationContext;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		factoryBean.setDataSource(dataSource);
		factoryBean.getObject();
		return factoryBean.getObject();
	}

	@Bean
	public UserMapper userMapper() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate.getMapper(UserMapper.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
//		HelloServiceImpl helloService = new HelloServiceImpl();
//		HelloService proxy = (HelloService)ProxyBean.getProxyBean(helloService, new MyInterceptor());
//		proxy.sayHello("james");
	}

}
