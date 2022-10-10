package com.misiontic2022.MascotasPerdidas.service;

import com.misiontic2022.MascotasPerdidas.interfaces.IMascota;
import com.misiontic2022.MascotasPerdidas.modelo.vo.DuenoVo;
import com.misiontic2022.MascotasPerdidas.modelo.vo.MascotaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaVoService {
    @Autowired
    private IMascota data;

    public void save(MascotaVo nueva_mascota) {
        data.save(nueva_mascota);
    }

    public List<MascotaVo> listar(){
        return (List<MascotaVo>) data.findAll();
    }

    public Optional<MascotaVo> listarById(Long codigo_mascota){
        return data.findById(codigo_mascota);
    }

    public void actualizar(Long codigo_mascota, DuenoVo nuevo_dueno) {
        Optional<MascotaVo> mascota = data.findById(codigo_mascota);
        MascotaVo miMascota = mascota.orElse(null);
        miMascota.setDueno(nuevo_dueno);
        miMascota.setEstado("Ya vinieron por mi");
        data.save(miMascota);
    }
}
