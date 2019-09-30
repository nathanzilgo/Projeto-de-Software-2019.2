package psoft.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import psoft.lab2.filters.TokenFilter;

@SpringBootApplication
public class Lab2Application {

	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		FilterRegistrationBean<TokenFilter> filterRB = new FilterRegistrationBean<TokenFilter>();
		filterRB.setFilter(new TokenFilter());
		filterRB.addUrlPatterns("/auth/usuarios");

		return filterRB;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

}
