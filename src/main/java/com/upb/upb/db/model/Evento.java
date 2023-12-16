package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EVENTORUSH")
public class Evento implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_EVENTO_ID_GENERATOR", sequenceName = "SEQ_EVENTO_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVENTO_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column
    private String nombreEvento;

    @Column
    private String description;

    @Column
    private LocalDate fechaEvento;

    @Column
    private LocalDate fechaFinEvento;

    @Column
    private LocalTime horaEvento;

    @Column
    private boolean estadoEvento;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_USUARIO", referencedColumnName = "id")
    private Usuario usuario;
}

    //Muchos eventos relacion con 1 usuario
    //Si se elimina un evento no se afecten a los usuarios == CascadeType.All
    //Multiples eventos un usuario
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "fk_usuario")
//    private Usuario usuario;
