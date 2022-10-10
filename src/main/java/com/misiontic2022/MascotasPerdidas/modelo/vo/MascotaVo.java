package com.misiontic2022.MascotasPerdidas.modelo.vo;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="mascota")
public class MascotaVo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota", nullable = false, unique = true)
    @Getter @Setter
    private Long id_mascota;

    @Column(name = "sexo_mascota")
    @Getter @Setter
    private String sexo_mascota;

    @Column(name = "raza_mascota")
    @Getter @Setter
    private String raza_mascota;

    @Column(name = "zona_de_encuentro", nullable = false)
    @Getter @Setter
    private String zona_de_encuentro;

    @Column(name = "fotografia", nullable = false)
    @Getter @Setter
    private String fotografia;

    @Column(name = "estado")
    @Getter @Setter
    private String estado = "Nadie ha venido por mi";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_mi_dueno_es", referencedColumnName = "cedula_dueno")
    @Getter @Setter
    private DuenoVo dueno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_encontrada_por", referencedColumnName = "cedula_samaritano", nullable = false)
    @Getter @Setter
    private SamaritanoVo samaritano;

    public MascotaVo() {
    }

}
