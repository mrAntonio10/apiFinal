package com.upb.upb.db.repository;

import com.upb.upb.db.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Optional<Evento> getEventoById(@Param("id") long id);
    @Query(" SELECT e FROM Evento e " +
            " INNER JOIN FETCH e.usuario u" +
            " WHERE u.estado = false AND e.estadoEvento = false")
    List<Evento> getEventosByEstadoEventoFalse();
}

