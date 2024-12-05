package com.confido.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.confido.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/GetStatement")
public class GetStatement extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			ArrayList al = m.getStatemnt();
			
			if(al.isEmpty()==true) {
				response.sendRedirect("/BankingApplication/Statement.html");
			}else {
				session.setAttribute("sal",m.sal);
				session.setAttribute("ral", m.ral);
				session.setAttribute("al", m.al);
				response.sendRedirect("/BankingApplication/Statementsuccess.jsp");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
