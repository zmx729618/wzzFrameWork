package org.wangzz.core.security.springsecurity.cxf;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSSecurityEngineResult;
import org.apache.ws.security.WSUsernameTokenPrincipal;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.apache.ws.security.handler.WSHandlerResult;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.wangzz.core.security.springsecurity.SpringSecurityUtils;

/**
 * 在WSS4J校验后设置SpringSecurity Context的CXF Interceptor.
 */
public class SpringSecurityInInterceptor extends AbstractPhaseInterceptor<Message> {

	private UserDetailsService userDetailsService;

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public SpringSecurityInInterceptor() {
		super(Phase.PRE_PROTOCOL);
		addAfter(WSS4JInInterceptor.class.getName());
	}

	public void handleMessage(Message message) throws Fault {
		String userName = getUserNameFromWSS4JResult(message);
		HttpServletRequest request = (HttpServletRequest) message.get("HTTP.REQUEST");

		UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		SpringSecurityUtils.saveUserDetailsToContext(userDetails, request);
	}

	/**
	 * 从Message中找出WSS4J校验后的用户名.
	 */
	@SuppressWarnings("unchecked")
	private String getUserNameFromWSS4JResult(Message message) {
		Vector<WSHandlerResult> results = (Vector<WSHandlerResult>) message
				.getContextualProperty(WSHandlerConstants.RECV_RESULTS);
		if (results != null && !results.isEmpty()) {
			for (WSHandlerResult result : results) {
				for (WSSecurityEngineResult securityResult : (Vector<WSSecurityEngineResult>) result.getResults()) {
					int action = (Integer) securityResult.get(WSSecurityEngineResult.TAG_ACTION);
					if ((action & WSConstants.UT) > 0) {
						WSUsernameTokenPrincipal token = (WSUsernameTokenPrincipal) securityResult
								.get(WSSecurityEngineResult.TAG_PRINCIPAL);
						return token.getName();
					}
				}
			}
		}
		return null;
	}
}
