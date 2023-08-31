package com.smhrd.security.configuration;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.smhrd.security.service.InMemoryUserDetailsService;
import com.smhrd.security.user.CustomGrantedAuthority;
import com.smhrd.security.user.CustomUser;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//		CustomUser customUser = new CustomUser("hjs_seq", "1234", new CustomGrantedAuthority("read"));
//		userDetailsManager.createUser(customUser);
//
//		return userDetailsManager;
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://DESKTOP-315Q6BO:3307/sesco_pre");
		dataSource.setUsername("root");
		dataSource.setPassword("132455");
		return dataSource;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SCryptPasswordEncoder sCryptPasswordEncoder() {
	    int cpuCost = 16384; // 적절한 값으로 설정
	    int memoryCost = 8; // 적절한 값으로 설정
	    int parallelization = 1; // 적절한 값으로 설정
	    int keyLength = 32; // 적절한 값으로 설정
	    int saltLength = 16; // 적절한 값으로 설정

	    return new SCryptPasswordEncoder(cpuCost, memoryCost, parallelization, keyLength, saltLength);
	}
	
	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new InMemoryUserDetailsManager();
	    }

	    
}