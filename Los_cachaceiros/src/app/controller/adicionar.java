package app.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import app.model.*;

@WebServlet("/adicionar")
@MultipartConfig
public class adicionar {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("adicionar.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome   = request.getParameter("txtNome"); 
		int ano  = Integer.parseInt(request.getParameter("txtAno"));
		String tipo = request.getParameter("txtTipo");
		String pais = request.getParameter("txtPais");
		String descricao = request.getParameter("txtDescricao");
		String preco = request.getParameter("txtPreco");
		String img	 = "bebida.png";
		
		//Obtendo o arquivo da img via upload
		Part arquivo = request.getPart("txtArquivo");
		if(arquivo.getSize() != 0) {
			//Obtendo o nome do arquivo
			String nomeArq = arquivo.getSubmittedFileName();
			
			//Obtendo a extensão do arquivo
			String est = nomeArq.split("\\.")[1];
			
			//Obtendo o caminho das imagens armazenadas
			String srcPath = request.getServletContext().getRealPath("fotos");
			
			//Montando o nome da imagem no imagem na var foto
			img = nome + "." + est;
			
			//Setando o caminho da url da img
			srcPath = srcPath + "/" + img;
			
			arquivo.write(srcPath);
		}
		
		//Criando um objeto Aluno
		Bebida bebida = new Bebida(nome, ano, tipo, pais, descricao, preco, img);
		
		//Inserindo os dados do aluno no banco de dados
		new DAO().adicionar(bebida);
		
		//Chamando a view do formulário de cadastro
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
