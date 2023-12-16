package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USUARIORUSH")
public class Usuario implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_USUARIO_ID_GENERATOR", sequenceName = "SEQ_USUARIO_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;



    @Column(name = "ESTADO")
    private Boolean estado;

//    /*
//    Un usuario puede tener multiples eventos
//    OneToMany
//     */
//    @OneToMany(mappedBy = "usuario")    //nombre de la relacion
//    private List<Evento> eventos = new ArrayList<Evento>();
}
