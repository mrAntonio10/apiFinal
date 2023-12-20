package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Evento;
import com.upb.upb.db.model.Usuario;
import com.upb.upb.db.repository.EventoRepository;
import com.upb.upb.db.repository.UsuarioRepository;
import com.upb.upb.db.service.EventoService;
import com.upb.upb.dto.EventoDto;
import com.upb.upb.request.EventoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EventoServiceImpl implements EventoService {
//Inyectar con el repositorio
    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<EventoDto> getEventosByEstadoEventoFalse() {
       List<EventoDto> eventoResponse = eventoRepository.getEventosByEstadoEventoFalse().stream().map( item ->
               new EventoDto(
                       item.getId(),
                       item.getNombreEvento(),
                       item.getDescription(),
                       item.getFechaEvento(),
                       item.getFechaFinEvento(),
                       item.getHoraEvento(),
                       item.isEstadoEvento(),
                       item.getUsuario().getNombreUsuario(),
                       item.getUsuario().getNombreCompleto()
               )

       ).sorted(Comparator.comparingLong(EventoDto::getId)).collect(Collectors.toList());
        return eventoResponse;
    }

    @Override
    public EventoDto getEventoById(Long id) {
        Optional<Evento> evento = eventoRepository.getEventoByIdAndEstadoFalse(id);

        if (!evento.isPresent())
            throw new NoSuchElementException("Usuario no encontrado");

        EventoDto eventoResponse = evento.map(item ->
                new EventoDto(
                        item.getId(),
                        item.getNombreEvento(),
                        item.getDescription(),
                        item.getFechaEvento(),
                        item.getFechaFinEvento(),
                        item.getHoraEvento(),
                        item.isEstadoEvento(),
                        item.getUsuario().getNombreUsuario(),
                        item.getUsuario().getNombreCompleto()
                )
        ).get();

        return eventoResponse;
    }

    @Transactional
    @Override
    public Long save(EventoRequest eventoDto) {
        //Paso 1, validar el usuario existente
        Optional<Usuario> usuarioOpt = usuarioRepository.findByIdAndEstadoFalse(eventoDto.getUsuarioId());
        if(!usuarioOpt.isPresent())
            throw new NoSuchElementException("Usuario de id: " + usuarioOpt.get().getId() + " no existente");

        Optional<Evento> eventoOpt = eventoRepository.getEventoByIdAndEstadoFalse(eventoDto.getId());

        if(!eventoOpt.isPresent()) {    //Si no existe un evento se crea uno nuevo
            Evento evento = new Evento();

            evento.setUsuario(usuarioOpt.get());
            evento.setNombreEvento(eventoDto.getNombreEvento());
            evento.setDescription(eventoDto.getDescription());
            evento.setFechaEvento(eventoDto.getFechaEvento());
            evento.setHoraEvento(eventoDto.getHoraEvento());
            evento.setFechaFinEvento(eventoDto.getFechaFinEvento());
            evento.setEstadoEvento(eventoDto.isEstadoEvento());  //el estado eliminado es false al crear un evento

            eventoRepository.save(evento);
            return evento.getId();

        } else {    //caso contrario, se actualiza
            Evento evento = eventoOpt.get();

            evento.setUsuario(usuarioOpt.get());
            evento.setNombreEvento(eventoDto.getNombreEvento());
            evento.setDescription(eventoDto.getDescription());
            evento.setFechaEvento(eventoDto.getFechaEvento());
            evento.setHoraEvento(eventoDto.getHoraEvento());
            evento.setFechaFinEvento(eventoDto.getFechaFinEvento());
            evento.setEstadoEvento(eventoDto.isEstadoEvento());  //el estado eliminado es false al crear un evento

            eventoRepository.save(evento);
            return evento.getId();
        }

    }
}
