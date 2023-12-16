package com.upb.upb;


import com.upb.upb.db.model.Evento;
import com.upb.upb.db.model.Usuario;
import com.upb.upb.db.repository.EventoRepository;
import com.upb.upb.db.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;


@Slf4j
@SpringBootApplication
public class UpbGestionApplication implements CommandLineRunner {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EventoRepository eventoRepository;

	public static void main(String[] args) {
		SpringApplication.run(UpbGestionApplication.class, args);
		log.info("API 2023 - UPB SANTA CRUZ");
	}

	@Override
	public void run(String... arg) throws Exception{
		addUser();
	}

	private void addUser(){
//		if(usuarioRepository.findAll().isEmpty()) {
//			Usuario usuario = new Usuario();
//			usuario.setNombreUsuario("admin");
//			usuario.setPassword("password");
//			usuario.setNombreCompleto("Administrador de Sistema");
//			usuario.setEstado(false);
//			usuarioRepository.save(usuario);
//
//			Usuario usuario2 = new Usuario();
//			usuario2.setNombreUsuario("marco");
//			usuario2.setPassword("marcoro10");
//			usuario2.setNombreCompleto("Marco Antonio Roca Montenegro");
//			usuario2.setEstado(false);
//			usuarioRepository.save(usuario2);
//
//
//		}

		//EVENTOS CON USUARIOS
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("admin2");
		usuario.setPassword("password2");
		usuario.setNombreCompleto("Administrador de Sistema2");
		usuario.setEstado(false);

		usuarioRepository.save(usuario);

		Evento evento = new Evento();
		evento.setEstadoEvento(false);
		evento.setFechaEvento(LocalDate.of(2021, Month.JANUARY, 1));
		evento.setFechaFinEvento(LocalDate.of(2021, Month.JANUARY, 20));
		evento.setHoraEvento(LocalTime.of(12,30,20));
		evento.setNombreEvento("ComiLona");
		evento.setDescription("Se va a realizar una comilona de choripanesss");
				evento.setUsuario(usuario);

		eventoRepository.save(evento);
	}


}
