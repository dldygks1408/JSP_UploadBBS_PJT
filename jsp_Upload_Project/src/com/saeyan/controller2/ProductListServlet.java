package com.saeyan.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productList.do")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pDao = ProductDAO.getInstance();
		
		List<ProductVO> productList = pDao.selectAllProducts();
		request.setAttribute("productList", productList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

	}
}
