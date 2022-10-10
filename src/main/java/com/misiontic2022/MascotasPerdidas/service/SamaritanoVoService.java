package com.misiontic2022.MascotasPerdidas.service;

import com.misiontic2022.MascotasPerdidas.interfaces.ISamaritano;
import com.misiontic2022.MascotasPerdidas.modelo.vo.SamaritanoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SamaritanoVoService {
    @Autowired
    private ISamaritano data;

    public void save(SamaritanoVo nuevo_samaritano) {
        data.save(nuevo_samaritano);
    }
}
