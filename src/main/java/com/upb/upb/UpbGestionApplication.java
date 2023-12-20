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
		/*
		if(usuarioRepository.findAll().isEmpty()) {
			Usuario usuario = new Usuario();
			usuario.setNombreUsuario("admin");
			usuario.setPassword("password");
			usuario.setNombreCompleto("Administrador de Sistema");
			usuario.setEstado(false);
			usuarioRepository.save(usuario);

			Usuario usuario2 = new Usuario();
			usuario2.setNombreUsuario("marco");
			usuario2.setPassword("marcoro10");
			usuario2.setNombreCompleto("Marco Antonio Roca Montenegro");
			usuario2.setEstado(false);
			usuarioRepository.save(usuario2);
		}

		 */

			//EVENTOS CON USUARIOS
			Usuario usuario1 = new Usuario();
			usuario1.setNombreUsuario("admin2");
			usuario1.setPassword("password2");
			usuario1.setNombreCompleto("Gerente de Sistema");
			usuario1.setEstado(false);

			usuarioRepository.save(usuario1);

			Usuario usuario2 = new Usuario();
			usuario2.setNombreUsuario("admin3");
			usuario2.setPassword("123456");
			usuario2.setNombreCompleto("Financiero");
			usuario2.setEstado(false);

			usuarioRepository.save(usuario2);

			Usuario usuario3 = new Usuario();
			usuario3.setNombreUsuario("admin4");
			usuario3.setPassword("123");
			usuario3.setNombreCompleto("Analista de datos");
			usuario3.setEstado(false);

			usuarioRepository.save(usuario3);

			Usuario usuario4 = new Usuario();
			usuario4.setNombreUsuario("admin5");
			usuario4.setPassword("marcoloco");
			usuario4.setNombreCompleto("Administrador de empresas");
			usuario4.setEstado(false);

			usuarioRepository.save(usuario4);

			Usuario usuario5 = new Usuario();
			usuario5.setNombreUsuario("admin6");
			usuario5.setPassword("martinloco");
			usuario5.setNombreCompleto("Sistemas de sistemas");
			usuario5.setEstado(false);

			usuarioRepository.save(usuario5);

			Evento evento1 = new Evento();
			evento1.setEstadoEvento(false);
			evento1.setFechaEvento(LocalDate.of(2021, Month.JANUARY, 1));
			evento1.setFechaFinEvento(LocalDate.of(2021, Month.JANUARY, 20));
			evento1.setHoraEvento(LocalTime.of(12,30,20));
			evento1.setNombreEvento("ComiLona");
			evento1.setDescription("Se va a realizar una comilona de choripanesss");
			evento1.setUsuario(usuario1);
			evento1.setUsuario(usuario2);

			eventoRepository.save(evento1);

			Evento evento2 = new Evento();
			evento2.setEstadoEvento(false);
			evento2.setFechaEvento(LocalDate.of(2021, Month.DECEMBER, 20));
			evento2.setFechaFinEvento(LocalDate.of(2021, Month.DECEMBER, 20));
			evento2.setHoraEvento(LocalTime.of(20,30,0));
			evento2.setNombreEvento("Cumple Justin");
			evento2.setDescription("Junte en su casa a las 8:30 pm");
			evento2.setUsuario(usuario5);

			eventoRepository.save(evento2);

			Evento evento3 = new Evento();
			evento3.setEstadoEvento(false);
			evento3.setFechaEvento(LocalDate.of(2021, Month.DECEMBER, 22));
			evento3.setFechaFinEvento(LocalDate.of(2021, Month.DECEMBER, 23));
			evento3.setHoraEvento(LocalTime.of(20,30,0));
			evento3.setNombreEvento("Cena Navideña");
			evento3.setDescription("Junte en la casa de Nicolas");
			evento3.setUsuario(usuario1);
			evento3.setUsuario(usuario2);
			evento3.setUsuario(usuario3);
			evento3.setUsuario(usuario4);
			evento3.setUsuario(usuario5);

			eventoRepository.save(evento3);

			Evento evento4 = new Evento();
			evento4.setEstadoEvento(false);
			evento4.setFechaEvento(LocalDate.of(2021, Month.JANUARY, 1));
			evento4.setFechaFinEvento(LocalDate.of(2021, Month.JANUARY, 20));
			evento4.setHoraEvento(LocalTime.of(12,30,0));
			evento4.setNombreEvento("Cine en Ventura Mall");
			evento4.setDescription("Salir a ver una peli con los amigos");
			evento4.setUsuario(usuario1);
			evento4.setUsuario(usuario5);
			evento4.setUsuario(usuario4);

			eventoRepository.save(evento4);
	}

}
