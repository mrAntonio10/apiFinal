package com.upb.upb.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventoDto {
    private Long id;

    private String nombreEvento;

    private String description;

    private LocalDate fechaEvento;

    private LocalDate fechaFinEvento;

    private LocalTime horaEvento;

    private boolean estadoEvento;

    private String username;

    private String nombreCompleto;
}
