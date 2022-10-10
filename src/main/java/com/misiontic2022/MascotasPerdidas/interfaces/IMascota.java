package com.misiontic2022.MascotasPerdidas.interfaces;

import com.misiontic2022.MascotasPerdidas.modelo.vo.MascotaVo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascota extends CrudRepository<MascotaVo, Long> {
}
