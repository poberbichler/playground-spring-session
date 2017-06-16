package at.oberbichler.playtime.springsession.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author patrick
 * @since 06.2017
 */
@Component
public class DefaultSessionAttributeInterceptor implements HandlerInterceptor {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (request.getSession().getAttribute("sessionText") == null) {
			logger.info("adding [sessionText]");
			request.getSession().setAttribute("sessionText", "hello from my spring application");
		}

		return true;
	}
}
