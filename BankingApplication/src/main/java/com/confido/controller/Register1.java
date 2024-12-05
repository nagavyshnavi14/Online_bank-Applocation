package com.confido.controller;

import java.io.IOException;

import com.confido.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register1")
public class Register1 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String custID = request.getParameter("custID");
		String saccno = request.getParameter("accno");//collects the data in the form of String
		int accno = Integer.parseInt(saccno);//converts the string data to int data
		
		String pwd = request.getParameter("pwd");
		String sbal = request.getParameter("bal");//collects the data in the form of String
		int bal = Integer.parseInt(sbal);//converts the string data to int data
		
		String email = request.getParameter("email");
		try {
			Model m = new Model();
			m.setName(name);
			m.setCustID(custID);
			m.setAccno(accno);
			m.setPwd(pwd);
			m.setBal(bal);
			m.setEmail(email);
			
			boolean b = m.register();
			if(b==true) {
				response.sendRedirect("/BankingApplication/SuccessReg.html");
			}else {
				response.sendRedirect("/BankingApplication/FailureReg.html");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
