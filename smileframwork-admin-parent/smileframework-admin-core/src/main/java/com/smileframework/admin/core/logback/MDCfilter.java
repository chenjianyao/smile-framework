package com.smileframework.admin.core.logback;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;

/**
 * 
 * @author chenjian
 * @since 2017年3月3日 下午2:20:43
 */
public class MDCfilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain ch)
			throws IOException, ServletException {
		String uuid = "T=" + UUID.randomUUID().toString().replace("-", "");
		MDC.put("MDC-SMILE", uuid);
		req.setAttribute("MDC-SMILEl-LOG", uuid);
		HttpServletResponse p = (HttpServletResponse) resp;
		p.setHeader("MDC-SMILEl-LOG", uuid);
		ch.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
