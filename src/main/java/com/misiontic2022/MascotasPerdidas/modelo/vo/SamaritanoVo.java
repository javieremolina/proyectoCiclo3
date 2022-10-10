package com.misiontic2022.MascotasPerdidas.modelo.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="samaritano")
public class SamaritanoVo {
    @Id
    @Column(nullable = false)
    @Getter @Setter
    private Long cedula_samaritano;

    @Getter @Setter
    @Column(name = "primer_nombre_samaritano", nullable = false)
    private String primer_nombre_samaritano;

    @Getter @Setter
    @Column(name = "primer_apellido_samaritano", nullable = false)
    private String primer_apellido_samaritano;

    @Getter @Setter
    @Column(name = "telefono_samaritano", nullable = false)
    private String telefono_samaritano;

    @Getter @Setter
    @Column(name = "direccion_samaritano", nullable = false)
    private String direccion_samaritano;

    @OneToMany(targetEntity = MascotaVo.class)
    private List<MascotaVo> mascotaVoList;

    public SamaritanoVo(){
    }
}