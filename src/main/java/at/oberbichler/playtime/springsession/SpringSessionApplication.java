package at.oberbichler.playtime.springsession;

import at.oberbichler.playtime.springsession.web.DefaultSessionAttributeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableRedisHttpSession
public class SpringSessionApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringSessionApplication.class, args);
	}

	@Autowired
	private DefaultSessionAttributeInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}
}
