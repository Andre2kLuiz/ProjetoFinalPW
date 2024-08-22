package com.projetopw.projetofinalpw;

import com.projetopw.projetofinalpw.domain.Endereco;
import com.projetopw.projetofinalpw.domain.Usuario;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableConfigurationProperties(RsaKeyProperties.class)
public class ProjetofinalpwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetofinalpwApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	};

//		@Autowired
//		SecurityUserRerpository securityUserRerpository;
//
//		@Autowired
//		BCryptPasswordEncoder encoder;
	@PostConstruct
	public void started() {
		Usuario u = new Usuario();

		u.setNome("Joao");
		u.setSenha("password");


		Endereco e = new Endereco();
		e.setRua("Rua do Cacete");
		e.setNumero(20);
		e.setCep("59280-000");
		e.setEstado("Rio Grande do Norte");
		e.setBairro("Bairro do Norte");
		e.setRua("Natal");

		u.setEndereco(e);

//		SecurityUser securityUser = new SecurityUser();
//		securityUser.setPessoa(p);
//		securityUser.setUsername("admin");
//		securityUser.setPassword(encoder.encode("admin"));
//
//		securityUserRerpository.save(securityUser);
	}
}
