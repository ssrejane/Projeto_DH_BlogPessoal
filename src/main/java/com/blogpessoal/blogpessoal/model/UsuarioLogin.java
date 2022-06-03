package com.blogpessoal.blogpessoal.model;

public class UsuarioLogin {

	// classe interna do spring - será apenas para
	// entregar uma resposta quando o usuario logar no sistema.

	private long id;
	private String nome;
	private String usuario;
	private String senha;
	private String token;
	private String foto;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
