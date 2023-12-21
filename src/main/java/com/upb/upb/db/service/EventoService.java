package com.upb.upb.db.service;

import com.upb.upb.db.model.Evento;
import com.upb.upb.dto.EventoDto;
import com.upb.upb.request.EventoRequest;

import java.util.List;

public interface EventoService {
    List<EventoDto> getEventosByEstadoEventoFalse();

    EventoDto getEventoById(Long id) throws Exception;
    Long save(EventoRequest eventoDto);


    List<Evento> getAll();
    Long eliminarTodo(List<Evento> eventoList);


}
