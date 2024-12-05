package com.confido.controller;

import java.io.IOException;

import com.confido.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/CheckBalance")
public class CheckBalance extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			
			boolean b = m.CheckBalance();
			if(b==true) {
				session.setAttribute("bal", m.getBal());
				response.sendRedirect("/BankingApplication/BalanceView.jsp");
			}else {
				response.sendRedirect("/BankingApplication/BalanceFail.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
