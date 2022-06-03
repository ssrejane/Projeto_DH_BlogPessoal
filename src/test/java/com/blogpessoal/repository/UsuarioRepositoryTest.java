package com.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.blogpessoal.blogpessoal.model.Usuario;
import com.blogpessoal.blogpessoal.repository.UsuarioRepository;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// Essa notação indica que o ciclo de vida da classe teste será por classe

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L, "Zé Colmeia", "roba_lanche@email.com", "123456789",
				"https://image1.com/seilaonde.jpg"));
		usuarioRepository.save(
				new Usuario(0L, "Fagner Leitão", "fagleitao@gmail.com", "00008764", "https://imagem2345.com.jpg"));
		usuarioRepository.save(
				new Usuario(0L, "Luis Inacio", "lulapt@globo.com", "33345624", "https://imagemdainternet.com/2.jpg"));
		usuarioRepository
				.save(new Usuario(0L, "Veronica Tereza", "vtereza@globo.com", "3476273653", "https://imagemdanet.jpg"));
	}

	@Test
	@DisplayName("Retorna 1 usuário")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("escola123@globo.com");
		assertTrue(usuario.get().getUsuario().equals("escola123@globo.com"));
	}

	@Test
	@DisplayName("Retorna 3 usuário")
	public void deveRetornarTresUsuario() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findByNomeContainingIgnoreCase("Colmeia");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Zé Colmeia"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Harry Potter"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Anakin Skywalker"));
	}

	}
