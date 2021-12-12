package com.springboot.projectweb.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.projectweb.models.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
    
}
