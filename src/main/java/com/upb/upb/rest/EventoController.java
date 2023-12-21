package com.upb.upb.rest;

import com.upb.upb.db.model.Evento;
import com.upb.upb.db.service.EventoService;
import com.upb.upb.request.EventoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class EventoController {
    @Autowired
    EventoService eventoService;

    @GetMapping("")
    public ResponseEntity<?> eventoFindAll(){
        try{
            log .info("Ingresando al servicio listar todos los eventos");
            return ok(eventoService.getEventosByEstadoEventoFalse());
        } catch (Exception e){
            log.info("Error inesperado {}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Eventos no encontrados");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        }
    }

    @GetMapping("/{idEvento}")
    public ResponseEntity<?> eventoFindById(@PathVariable("idEvento") Long id){
        try{
            log .info("Ingresando al servicio listar evento por id: "+id);
            return ok(eventoService.getEventoById(id));
        } catch (NoSuchElementException e){
            log.info("Error inesperado {}", e);
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Evento con id: "+ id +" no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        }
        catch (Exception e){
            log.info("Error inesperado {}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Error inesperado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> insertEvent(@RequestBody EventoRequest eventoDto){
        try{
            log.info("Ingresan al servicio guardar nuevo evento");
            return ok(eventoService.save(eventoDto));
        } catch (NoSuchElementException e){
            log.info("Error inesperado en insertar evento{}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "No se pudo cargar el evento, usuario con id: "+eventoDto.getUsuarioId()+" no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " "+HttpStatus.NOT_FOUND.getReasonPhrase());
            return ResponseEntity.badRequest().body(responseBody);
        }
        catch (Exception e){
            log.info("Error inesperado en insertar evento{}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "No se pudo cargar el evento ni identificar el error");
            return ResponseEntity.badRequest().body(responseBody);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> updateEvent(@RequestBody EventoRequest eventoDto){
        try{
            log.info("Ingresan al servicio guardar nuevo evento");
            return ok(eventoService.save(eventoDto));
        } catch (NoSuchElementException e){
            log.info("Error inesperado en insertar evento{}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "No se pudo cargar el evento, usuario con id: "+eventoDto.getUsuarioId()+" no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " "+HttpStatus.NOT_FOUND.getReasonPhrase());
            return ResponseEntity.badRequest().body(responseBody);
        }
        catch (Exception e){
            log.info("Error inesperado en insertar evento{}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "No se pudo cargar el evento ni identificar el error");
            return ResponseEntity.badRequest().body(responseBody);
        }
    }


    @PutMapping("/borrarTodo")
    public ResponseEntity<?> eliminarTodo(){
        try{
            List<Evento> eventosList = eventoService.getAll();
            eventoService.eliminarTodo(eventosList);
            return null;
        } catch (NoSuchElementException e){
            log.info("Error inesperado en insertar evento{}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " "+HttpStatus.NOT_FOUND.getReasonPhrase());
            return ResponseEntity.badRequest().body(responseBody);
        }
        catch (Exception e){
            log.info("Error inesperado en insertar evento{}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "No se pudo cargar el evento ni identificar el error");
            return ResponseEntity.badRequest().body(responseBody);
        }
    }
}

