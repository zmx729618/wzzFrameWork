package org.wangzz.core.security.springsecurity.cxf;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 清除SecurityContext的Interceptor.
 */
public class SpringSecurityOutInterceptor extends AbstractPhaseInterceptor<Message> {

	public SpringSecurityOutInterceptor() {
		super(Phase.MARSHAL);
	}

	public void handleMessage(Message message) throws Fault {
		SecurityContextHolder.clearContext();
	}
}
