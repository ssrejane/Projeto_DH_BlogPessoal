package com.blogpessoal.blogpessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id //coloca o atributo como chave primaria dentro do banco de dados.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=5,max=100)
	private String nome;
	
	public Usuario(long id, String nome, String usuario, String senha, String foto) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
	}
	
	public Usuario()
	{
		
	}

	@Schema(example = "email@email.com.br")
	@NotNull(message = "O atributo usuário é obrigatório")
	@Email(message = "O atributo usuário deve ser um e-mail válido")
	
	private String usuario;
	
	@NotNull
	@Size(min=6,max=10)
	private String senha;
	
	private String foto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
