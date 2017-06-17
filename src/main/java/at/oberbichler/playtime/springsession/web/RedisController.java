package at.oberbichler.playtime.springsession.web;

import at.oberbichler.playtime.springsession.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author patrick
 * @since 06.2017
 */
@RestController
@RequestMapping("redis")
public class RedisController {
	private final RedisService redisService;

	@Autowired
	public RedisController(RedisService redisService) {
		this.redisService = redisService;
	}

	@GetMapping("{key}")
	public String getValue(@PathVariable String key) {
		return redisService.readValue(key);
	}

	@PostMapping("{key}/{value}")
	public void putValue(@PathVariable String key, @PathVariable  String value) {
		redisService.setValue(key, value);
	}
}
