package at.oberbichler.playtime.springsession.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author patrick
 * @since 06.2017
 */
@Component
public class DefaultSessionAttributeInterceptor implements HandlerInterceptor {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final UUID uuid;

	@Autowired
	public DefaultSessionAttributeInterceptor(UUID uuid) {
		this.uuid = uuid;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("initialUUID") == null) {
			logger.info("adding [initialUUID]");
			session.setAttribute("initialUUID", this.uuid);
		}

		return true;
	}
}
