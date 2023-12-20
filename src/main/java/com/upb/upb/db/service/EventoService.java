package com.upb.upb.db.service;

import com.upb.upb.dto.EventoDto;
import com.upb.upb.request.EventoRequest;

import java.util.List;

public interface EventoService {
    List<EventoDto> getEventosByEstadoEventoFalse();

    EventoDto getEventoById(Long id) throws Exception;
    Long save(EventoRequest eventoDto);

}
