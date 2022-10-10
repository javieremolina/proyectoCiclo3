package com.misiontic2022.MascotasPerdidas.controller;

import com.misiontic2022.MascotasPerdidas.modelo.vo.DuenoVo;
import com.misiontic2022.MascotasPerdidas.modelo.vo.MascotaVo;
import com.misiontic2022.MascotasPerdidas.modelo.vo.SamaritanoVo;
import com.misiontic2022.MascotasPerdidas.service.DuenoVoService;
import com.misiontic2022.MascotasPerdidas.service.MascotaVoService;
import com.misiontic2022.MascotasPerdidas.service.SamaritanoVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class controlador {
    @Autowired
    private SamaritanoVoService serviceSamaritano;
    @Autowired
    private MascotaVoService serviceMascota;
    @Autowired
    private DuenoVoService serviceDueno;

    @GetMapping("/")
    public String iniciar(){
        return "index";
    }

    @GetMapping("/registrar")
    public String registrar(Model model){
        model.addAttribute("samaritano", new SamaritanoVo());
        model.addAttribute("mascota", new MascotaVo());
        return "registrar";
    }

    @PostMapping("/save")
    public String save(@Validated SamaritanoVo nuevo_samaritano, @Validated MascotaVo nueva_mascota){
        serviceSamaritano.save(nuevo_samaritano);
        nueva_mascota.setSamaritano(nuevo_samaritano);
        serviceMascota.save(nueva_mascota);
        return "redirect:/consultar";
    }

    @GetMapping("/consultar")
    public ModelAndView listar(){
        List<MascotaVo> mascotas = serviceMascota.listar();
        return new ModelAndView("consultar")
                .addObject("mascotas", mascotas);
    }

    @GetMapping("/asignar-dueno/{id_mascota}")
    public ModelAndView buscarMascota(@PathVariable Long id_mascota, Model model) {

        Optional<MascotaVo> mascota = serviceMascota.listarById(id_mascota);
        MascotaVo miMascota = mascota.orElse(null);
        model.addAttribute("dueno", new DuenoVo());

        return new ModelAndView("soy-su-dueno")
                .addObject("miMascota", miMascota);
    }

    @PostMapping("/save-dueno/{id_mascota}")
    public String save(@PathVariable Long id_mascota, @Validated DuenoVo nuevo_dueno){
        serviceDueno.save(nuevo_dueno);
        serviceMascota.actualizar(id_mascota, nuevo_dueno);
        return "redirect:/consultar";
    }
}
