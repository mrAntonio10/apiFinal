package com.upb.upb.rest;

import com.upb.upb.db.model.Usuario;
import com.upb.upb.db.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;


    //@GetMapping("/{nombreUsuario}/{password}")
    @GetMapping("/findAllUsers")
    public ResponseEntity<?> usuarioFindAll(
            //@PathVariable String nombreUsuario,
            //@PathVariable String password
            ){
        try{
            log .info("Solicitud de acceso por usuario");
            return ok(usuarioService.findAllUsers());
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            log.error("Errorrr XDDDD");

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Error en busqueda de usuarios");
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping("/logIn")
    ResponseEntity<Long> logIn(@RequestBody Usuario usuario) {
        try {
            return ok(usuarioService.findByUsernameAndPassword(usuario.getNombreUsuario(), usuario.getPassword()));
        }catch (Exception e){
            log.info("Error inesperado {}", e);
            log.info("Error inesperado {}", e);


            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Usuario " + usuario.getNombreUsuario() + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping("")
    ResponseEntity<Long> guardarUsuario(@RequestBody Usuario usuarioNuevo) {
        try {
            return ok(usuarioService.save(usuarioNuevo));
        }catch (Exception e){
            log.info("Error inesperado {}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Error al guardar usuario");
            responseBody.put("status", HttpStatus.CONFLICT.value() + " " + HttpStatus.CONFLICT.getReasonPhrase());
            responseBody.put("catch", e);

            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("")
    ResponseEntity<?> modificarUsuario(@RequestBody Usuario usuarioNuevo) {
        try {
            return ok(usuarioService.save(usuarioNuevo));
        } catch (NoSuchElementException e) {
            log.info("Usuario no encontrado, message {}", e.getMessage());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Usuario con id " + usuarioNuevo.getId() + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body("Error inesperado");
        }
    }
}
