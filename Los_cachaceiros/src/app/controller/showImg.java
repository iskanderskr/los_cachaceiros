package app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Bebida;
import app.model.DAO;

@WebServlet("/showImg")
public class ShowImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		Bebida bebida = new DAO().resgatar(id);

		String strPath = request.getServletContext().getRealPath("dist/img");

		String nomeArq = "foto1.jpg";

		if (bebida != null && bebida.getImg() != null) {
			nomeArq = bebida.getImg();
		}

		Path pathImagem = Paths.get(strPath, nomeArq);

		byte[] imagemByte = Files.readAllBytes(pathImagem);

		response.setContentType("image/png");
		response.setContentLength(imagemByte.length);
		response.getOutputStream().write(imagemByte);
	}
}
