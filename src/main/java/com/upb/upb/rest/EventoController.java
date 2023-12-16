package com.upb.upb.rest;

import com.upb.upb.db.service.EventoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
            log .info("Listando todos los eventos");
            return ok(eventoService.getEventosByEstadoEventoFalse());
        } catch (Exception e){
            log.info("Error inesperado {}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Eventos no encontrados");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(null);
        }
    }
}
