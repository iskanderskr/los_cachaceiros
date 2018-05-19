package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import app.model.Bebida;
import app.model.DAO;

@WebServlet("/editar")
public class edicao extends HttpServlet{
String id;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Bebida bebida = new DAO().resgatar(id);
				
		request.setAttribute("bebida", bebida);
		
		request.getRequestDispatcher("edicao.jsp").forward(request, response);
	}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String nome  = request.getParameter("txtNome"); 
	int ano = Integer.parseInt(request.getParameter("txtAno"));
	String tipo   = request.getParameter("txtTipo");
	String pais   = request.getParameter("txtPais");
	String descricao   = request.getParameter("txtDescricao");
	String preco   = request.getParameter("txtPreco"); 
	String img	 = "bebida.png";
	
	
	Part arquivo = request.getPart("txtArquivo");
	if(arquivo.getSize() != 0) {
		
		String nomeArq = arquivo.getSubmittedFileName();
	
		String est = nomeArq.split("\\.")[1];

		String srcPath = request.getServletContext().getRealPath("fotos");

		img = id + "." + est;
		
		srcPath = srcPath + "/" + img;
		
		arquivo.write(srcPath);
	}
	
	Bebida bebida = new Bebida( nome, ano, tipo, pais, descricao, preco, img);
	
	new DAO().atualizar(bebida);

	response.sendRedirect("editar?id="+id);
}
}
