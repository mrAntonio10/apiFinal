package com.upb.upb.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventoRequest {
    private Long id;

    private String nombreEvento;

    private String description;

    private LocalDate fechaEvento;

    private LocalDate fechaFinEvento;

    private LocalTime horaEvento;

    private boolean estadoEvento;

    private Long usuarioId;
}


