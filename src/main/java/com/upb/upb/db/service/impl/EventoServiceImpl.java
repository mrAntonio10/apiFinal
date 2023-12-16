package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Evento;
import com.upb.upb.db.repository.EventoRepository;
import com.upb.upb.db.service.EventoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EventoServiceImpl implements EventoService {
//Inyectar con el repositorio
    @Autowired
    EventoRepository eventoRepository;

    @Override
    public List<Evento> getEventosByEstadoEventoFalse() {
        return eventoRepository.getEventosByEstadoEventoFalse();
    }

    @Override
    public Optional<Evento> getEventoById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long save(Evento Evento) {
        return null;
    }
}
