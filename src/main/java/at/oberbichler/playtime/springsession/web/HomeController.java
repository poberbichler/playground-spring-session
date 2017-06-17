package at.oberbichler.playtime.springsession.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
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
	private final ServerProperties props;

	@Autowired
	public HomeController(ServerProperties props) {
		this.props = props;
	}

	@GetMapping
	public ModelAndView home(HttpSession httpSession) {
		return new ModelAndView("home", new ModelMap()
				.addAttribute("sessionId", httpSession.getId())
				.addAttribute("initialPort", httpSession.getAttribute("initialPort"))
				.addAttribute("currentPort", props.getPort()));
	}
}
