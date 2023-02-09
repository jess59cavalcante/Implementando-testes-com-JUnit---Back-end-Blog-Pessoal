package org.generation.blogpessoal.repository;

import java.util.Optional;

import org.generation.blogpessoal.model.Usuario;
import org.generation.blogpessoal.repository.UsuarioRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start () {
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L,"Ana Carolina","carol@email.com","13465278","https://i.imgur.com/FETvs20.jpg"));
		usuarioRepository.save(new Usuario(0L,"Daniela","dani@email.com","98745681","https://i.imgur.com/NtyGneo.jpg"));
		usuarioRepository.save(new Usuario(0L,"Jessica","je@email.com","24874581","https://i.imgur.com/mB3VM2N.jpg"));
		usuarioRepository.save(new Usuario(0L,"Rafael","fael@email.com","54698711","https://i.imgur.com/JR7kUFU.jpg"));
	}
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

	Optional<Usuario> usuario = usuarioRepository.findByUsuario("je@email.com");
	assertTrue(usuario.get().getUsuario().equals("je@email.com"));
}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
		
	}
	
}