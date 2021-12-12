package com.springboot.projectweb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.projectweb.models.entity.Empleado;
import com.springboot.projectweb.models.service.EmpleadoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
    	List<Empleado> empleados = empleadoService.listEmpleados();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("empleados", empleados);
        return "index";
    }
   

	@GetMapping("/agregar")
	public String agregar(Empleado empleado) {
		return "modificar";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid Empleado empleado, Errors errores) {
		if (errores.hasErrors()) {
			return "modificar";
		}
		empleadoService.Save(empleado);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{idEmpleado}")
    public String editar(Empleado empleado, Model model){
		empleado = empleadoService.findEmpleado(empleado);
        model.addAttribute("empleado", empleado);
        return "modificar";
    }
	
	
	@GetMapping("/eliminar")
    public String eliminar(Empleado empleado){
		empleadoService.Eliminar(empleado);
        return "redirect:/";
    }
}
