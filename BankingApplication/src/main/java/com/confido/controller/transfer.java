package com.confido.controller;

import java.io.IOException;

import com.confido.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/transfer")
public class transfer extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		String samt = request.getParameter("amt");
		long amt = Long.parseLong(samt);
		
		String sraccno = request.getParameter("raccno");
		
		int raccno = Integer.parseInt(sraccno);
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			m.setRaccno(raccno);
			m.setBal(amt);
			boolean b = m.transfer();
			if(b==true) {
				response.sendRedirect("/BankingApplication/Transfersuccess.html");
			}else {
				response.sendRedirect("/BankingApplication/TransferFail.html");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
