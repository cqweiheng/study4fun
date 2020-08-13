package com.example.mybatis02.mybatis;

import com.example.mybatis02.mybatis.plugins.MyPlugin;
import com.example.mybatis02.mybatis.plugins.ParamsPlugin;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 *
 * @date 2020/6/21 9:03
 * @author wei.heng
 */
@SpringBootApplication
@MapperScan(
	basePackages = "com.example.mybatis02.mybatis.*",
	sqlSessionTemplateRef = "sqlSessionTemplate",
	annotationClass = Repository.class
)
@EnableCaching
//@EnableWebSecurity
//public class MybatisApplication extends WebSecurityConfigurerAdapter {
@EnableEurekaClient
public class MybatisApplication {

	@Autowired
	private BasicDataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
//	@Autowired
//	private UserDetailsService userDetailsServiceImpl;
	@Value("${system.user.password.secret}")
	private String passwordSecret;

	String pwdQuery = " select user_name, pwd, available from t_user where user_name = ?";
	String roleQuery = "select u.user_name, r.role_name from t_user u, t_user_role ur, t_role r "
					 + " where u.id = ur.user_id and r.id = ur.role_id and u.user_name = ? ";

	/**
	 *
	 * 覆盖WebSecurityConfigurerAdapter用户详情方法
	 * @param auth 用户签名管理器构造器
	 * @date 2020/7/7 10:54
	 * @author wei.heng
	 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		/*// 使用自带的加密器
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		auth.jdbcAuthentication()
//			.passwordEncoder(passwordEncoder)
//			.dataSource(dataSource)
//			.usersByUsernameQuery(pwdQuery)
//			.authoritiesByUsernameQuery(roleQuery);*/
//
//		// 使用自己的密钥对密码进行加密
//		Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.passwordSecret);
//		// 设置自定义的密码服务合密码编码器
//		auth.userDetailsService(userDetailsServiceImpl)
//			.passwordEncoder(passwordEncoder);
//
//	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN')")
//			.and().rememberMe().tokenValiditySeconds(3600*24).key("remember-me-key")
//			// 启用http基础验证
//			.and().httpBasic()
//			.and().authorizeRequests().antMatchers("/**").permitAll()
//			// 使用默认登陆页面
//			.and().formLogin();
//			// 设置登录页面
////			.and().formLogin().loginPage("/login/page")
//			// 设置登陆后跳转页面
////				.defaultSuccessUrl("/admin/webcome1");
//		super.configure(http);
//	}

	/**
	 *
	 * 为mybatis加入插件
	 * @date 2020/6/21 9:03
	 * @author wei.heng
	 */
	@PostConstruct
	public void initMyBatis(){
		Interceptor myPlugin = new MyPlugin();
		Interceptor paramsPlugin = new ParamsPlugin();
		Properties properties = new Properties();
		properties.setProperty("key1", "value1");
		myPlugin.setProperties(properties);
		Configuration configuration = sqlSessionFactory.getConfiguration();
		configuration.addInterceptor(myPlugin);
		configuration.addInterceptor(paramsPlugin);
	}

	public static void main(String[] args) {

//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		System.out.println("==================");
//		System.out.println(passwordEncoder.encode("123"));

//		Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("passwordsecret20200707");
//		System.out.println("================");
//		System.out.println(passwordEncoder.encode("123456"));
//		System.out.println(passwordEncoder.encode("123"));
		SpringApplication.run(MybatisApplication.class, args);
	}

}
