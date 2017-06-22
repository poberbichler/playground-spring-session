package at.oberbichler.playtime.springsession.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author patrick
 * @since 06.2017
 */
@Controller
@RequestMapping({"/", "home"})
public class HomeController {
	private final UUID id;

	@Autowired
	public HomeController(UUID id) {
		this.id = id;
	}

	@GetMapping
	public ModelAndView home(HttpSession httpSession) {
		return new ModelAndView("home", new ModelMap()
				.addAttribute("sessionId", httpSession.getId())
				.addAttribute("initialUUID", httpSession.getAttribute("initialUUID"))
				.addAttribute("currentUUID", id));
	}
}
