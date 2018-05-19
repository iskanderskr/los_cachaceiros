package app.model;

public class Bebida{
	private int id;
	private String nome;
	private int ano;
	private String tipo;
	private String pais;
	private String descricao;
	private String preco;
	private String img;
	public Bebida() {
       this.nome = "";
       this.ano = 0;
       this.tipo = "";
       this.pais = "";
       this.descricao = "";
       this.preco = "";
       this.img = "";
    }
	public Bebida(String nome, int ano, String tipo, String pais, String descricao,String preco, String img) {
		this.nome = nome;
	    this.ano = ano;
	    this.tipo = tipo;
	    this.pais = pais;
	    this.descricao = descricao;
	    this.preco = preco;
	    this.img = img;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
