package com.upb.upb.db.service;

import com.upb.upb.db.model.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoService {
    List<Evento> getEventosByEstadoEventoFalse();

    Optional<Evento> getEventoById(Long id);
    Long save(Evento Evento);

}
