package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Bebida;
import app.model.DAO;

@WebServlet("/listagem")
public class Listagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Bebida> bebidas = new DAO().listar();
		request.setAttribute("bebidas", bebidas);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
