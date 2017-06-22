package at.oberbichler.playtime.springsession;

import at.oberbichler.playtime.springsession.web.DefaultSessionAttributeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.UUID;

@SpringBootApplication
@EnableRedisHttpSession
public class SpringSessionApplication implements WebMvcConfigurer {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringSessionApplication.class, args);
	}

	@Autowired
	private DefaultSessionAttributeInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}

	@Bean
	public UUID uuid() {
		UUID uuid = UUID.randomUUID();
		logger.info("created uuid [{}]", uuid);
		return uuid;
	}
}
