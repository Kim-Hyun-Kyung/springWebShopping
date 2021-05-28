package com.study.springboot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/js/**","/css/**","/images/**","/font/**","/html/**","/jsp/**");
		//해당 경로의 파일은 spring security가 무시할 수 있게 설정함 
	}
	 @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {

	        String password = passwordEncoder().encode("");

	        auth.inMemoryAuthentication().withUser("user").password(password).roles("USER");
	        auth.inMemoryAuthentication().withUser("manager").password(password).roles("MANAGER");
	        auth.inMemoryAuthentication().withUser("admin").password(password).roles("ADMIN");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests()
				/*
				 * .antMatchers("/admin/**").hasRole("ADMIN")//admin 사용자만 접근
				 * .antMatchers("/user/**").hasRole("USER")//basic role사용자만 접근
				 */
				.antMatchers("/**").permitAll() //권한없이 접근가능
				.and()
			.formLogin()//form기반으로 인증 기본HttpSession이용함
			.loginPage("/user/login")//기본제공form 말고 커스텀 로그인 form이용시 사용
			//이 때 커스텀 로그인 form의 action 경로와 loginPage()의 파라미터 경로가 일치해야 인증을 처리할 수 있습니다.
			.usernameParameter("username")//기본 name=username을 인식하나 이를 이용해 변경가능
			.passwordParameter("password")
			.permitAll()
			.loginProcessingUrl("/security_check") //로그인시도 후 실제 로그인 인증 절차가 진행되는 곳
			.permitAll()
			.defaultSuccessUrl("/Welcome") //로그인 성공시 이동되는 페이지(컨트롤러 메핑 필요)
			.failureUrl("/login/failed")
		.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //기본 url쓰지않고 지정함
			.logoutSuccessUrl("/login/logout")
			.invalidateHttpSession(true)//HttpSession 초기화
			//로그아웃시 특정 쿠키를 제거하고 싶으면 deleteCookies사용
			.and()
			.exceptionHandling().accessDeniedPage("/user/login");
			//예외 발생시 핸들링할 수 있는 메소드 
		//접근권한이 없을때 로그인 페이지로 이동하도록 함
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * @Bean public LoginService loginService() { return new LoginService(); }
	 */
}
