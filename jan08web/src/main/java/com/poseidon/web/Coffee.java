package com.poseidon.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.CoffeeDAO;

@WebServlet("/coffee")
public class Coffee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String bno = null;

    public Coffee() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeDAO dao = new CoffeeDAO();
		
		List<Map<String, Object>> list = dao.coffeeList();
		
		request.setAttribute("list", list); //list의 변수를 만들어줘서 list의 값을 넣어줌
		
		
		RequestDispatcher rd = request.getRequestDispatcher("coffee.jsp"); //coffee 사이트로 이동
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println(request.getParameter("drink"));
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String menu = request.getParameter("drink"); //커피 메뉴들을 불러옴
		
	
		/*
		 * CoffeeDTO dto = new CoffeeDTO();
		 * dto.setCoffee_name(request.getParameter("name"));
		 * dto.setTea_name(request.getParameter("pw1"));
		 */
		
		CoffeeDAO dao = new CoffeeDAO();
		int result = dao.Coffee(menu); //result 값에 커피 메뉴들을 저장
		//System.out.println("처리결과 : " + result);
		// 이동해주세요.
		if (result == 1) { //1이면 coffee 사이트로 아니면 에러 메세지 뜨게
			response.sendRedirect("./coffee");
		} else {
			response.sendRedirect("./error.jsp");
		}
	}
}


