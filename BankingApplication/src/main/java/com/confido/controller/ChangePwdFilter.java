package com.confido.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

public class ChangePwdFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String npwd = request.getParameter("npwd");
		String cpwd = request.getParameter("cpwd");
		if(npwd.equals(cpwd)) {
		chain.doFilter(request, response);
	}else {
		((HttpServletResponse) response).sendRedirect("/changepwdfail.html");
	}
	}
	}


