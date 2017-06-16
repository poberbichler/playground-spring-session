package at.oberbichler.playtime.springsession.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author patrick
 * @since 06.2017
 */
@Controller
@RequestMapping({"/", "home"})
public class HomeController {
	@GetMapping
	public ModelAndView home(HttpSession httpSession) {
		return new ModelAndView("home", new ModelMap()
				.addAttribute("sessionId", httpSession.getId())
				.addAttribute("sessionText", httpSession.getAttribute("sessionText")));
	}
}
