package app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import app.util.ConnectionFactory;

public class DAO {
	public void adicionar(Bebida bebida) {
		try {
			Connection con = ConnectionFactory.getConnection();

			String sql = "INSERT INTO bebida VALUES(default,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, bebida.getNome());
			ps.setInt(2, bebida.getAno());
			ps.setString(3, bebida.getTipo());
			ps.setString(4, bebida.getPais());
			ps.setString(5, bebida.getDescricao());
			ps.setString(6, bebida.getPreco());
			ps.setString(7, bebida.getImg());

			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public Bebida resgatar(String id) {
		try {
			Connection con = ConnectionFactory.getConnection();

			String sql = "SELECT * FROM bebida WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			Bebida bebida = new Bebida();

			if (rs.next()) {
				bebida.setNome(rs.getString("nome"));
				bebida.setAno(rs.getInt("ano"));
				bebida.setTipo(rs.getString("tipo"));
				bebida.setPais(rs.getString("pais"));
				bebida.setDescricao(rs.getString("descricao"));
				bebida.setPreco(rs.getString("preco"));
				bebida.setImg(rs.getString("img"));
			}

			ps.close();
			con.close();

			return bebida;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public int atualizar(Bebida bebida) {
		try {
			Connection con = ConnectionFactory.getConnection();

			String sql = "UPDATE bebida SET nome=?, ano=?, tipo=?, pais=?, descricao=?, preco=? , img=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, bebida.getNome());
			ps.setInt(2, bebida.getAno());
			ps.setString(3, bebida.getTipo());
			ps.setString(4, bebida.getPais());
			ps.setString(5, bebida.getDescricao());
			ps.setString(6, bebida.getPreco());
			ps.setString(7, bebida.getImg());
			ps.setInt(7, bebida.getId());

			int result = ps.executeUpdate();
			ps.close();
			con.close();

			return result;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void deletar(String id) {
		try {
			Connection con = ConnectionFactory.getConnection();

			String sql = "DELETE FROM bebida WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public ArrayList<Bebida> listar() {
		try {
			Connection con = ConnectionFactory.getConnection();

			String sql = "SELECT * FROM bebida";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			ArrayList<Bebida> bebidas = new ArrayList<>();

			while (rs.next()) {
				Bebida bebida = new Bebida();
				bebida.setNome(rs.getString("nome"));
				bebida.setAno(rs.getInt("ano"));
				bebida.setTipo(rs.getString("tipo"));
				bebida.setPais(rs.getString("pais"));
				bebida.setDescricao(rs.getString("descricao"));
				bebida.setPreco(rs.getString("preco"));
				bebida.setImg(rs.getString("img"));
				bebidas.add(bebida);
			}

			ps.close();
			con.close();

			return bebidas;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
