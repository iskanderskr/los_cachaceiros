package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.DAO;

@WebServlet("/excluir")
public class exclusao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtendo id para excluir
		String id = request.getParameter("id");
		
		//DAO para exclusao
		new DAO().deletar(id);
		
		//Redirecionando
		response.sendRedirect("index.jsp");
	}

}