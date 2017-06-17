package at.oberbichler.playtime.springsession.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static org.springframework.util.Assert.notNull;

/**
 * @author patrick
 * @since 06.2017
 */
@Service
public class RedisService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final StringRedisTemplate redisTemplate;

	@Autowired
	public RedisService(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public String readValue(String value) {
		return redisTemplate.opsForValue().get(value);
	}

	public void setValue(String key, String value) {
		notNull(key, "key must not be null");
		notNull(value, "value must not be null");

		redisTemplate.opsForValue().set(key, value);
	}

	@PostConstruct
	public void fillRedis() {
		logger.info("initializing redis with default values...");

		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ops.setIfAbsent("aaaa", "AAAA");
		ops.setIfAbsent("bbbb", "BBBB");
		ops.setIfAbsent("cccc", "CCCC");
		ops.setIfAbsent("dddd", "DDDD");
	}
}
