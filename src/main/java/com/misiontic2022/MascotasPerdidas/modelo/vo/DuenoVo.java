package com.misiontic2022.MascotasPerdidas.modelo.vo;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dueno")
public class DuenoVo {
    @Id
    @Column(nullable = false)
    @Getter @Setter
    private Long cedula_dueno;

    @Getter @Setter
    @Column(name = "primer_nombre_dueno", nullable = false)
    private String primer_nombre_dueno;

    @Getter @Setter
    @Column(name = "primer_apellido_dueno", nullable = false)
    private String primer_apellido_dueno;

    @Getter @Setter
    @Column(name = "telefono_dueno", nullable = false)
    private String telefono_dueno;

    @Getter @Setter
    @Column(name = "direccion_dueno", nullable = false)
    private String direccion_dueno;

    @OneToMany(targetEntity = MascotaVo.class)
    private List<MascotaVo> mascotaVoList;

    public DuenoVo(){
    }
}
