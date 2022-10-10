package com.misiontic2022.MascotasPerdidas.service;

import com.misiontic2022.MascotasPerdidas.interfaces.IDueno;
import com.misiontic2022.MascotasPerdidas.modelo.vo.DuenoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenoVoService {
    @Autowired
    private IDueno data;

    public void save(DuenoVo nuevo_dueno) {
        data.save(nuevo_dueno);
    }
}
