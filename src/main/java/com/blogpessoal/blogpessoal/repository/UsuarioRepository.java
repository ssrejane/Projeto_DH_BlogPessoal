package com.blogpessoal.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal.blogpessoal.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	public Optional <Usuario>findByUsuario(String usuario);
	//optional é um recurso para retornar alguns valores - e pode retornar nulo.

	public List <Usuario> findByNomeContainingIgnoreCase(String nome);

	
}
