package at.oberbichler.playtime.springsession.web;

import at.oberbichler.playtime.springsession.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author patrick
 * @since 06.2017
 */
@Controller
@RequestMapping({"/", "home"})
public class HomeController {
	private final RedisService redisService;

	@Autowired
	public HomeController(RedisService redisService) {
		this.redisService = redisService;
	}

	@GetMapping
	public ModelAndView home(HttpSession httpSession) {
		return new ModelAndView("home", new ModelMap()
				.addAttribute("sessionId", httpSession.getId())
				.addAttribute("sessionText", httpSession.getAttribute("sessionText")));
	}

	@ResponseBody
	@GetMapping("{value}")
	public String getValue(@PathVariable String value) {
		return redisService.readValue(value);
	}
}
