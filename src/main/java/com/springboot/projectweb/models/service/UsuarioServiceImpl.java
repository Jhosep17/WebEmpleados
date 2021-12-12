package com.springboot.projectweb.models.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.projectweb.models.dao.UsuarioDao;
import com.springboot.projectweb.models.entity.Rol;
import com.springboot.projectweb.models.entity.Usuario;


@Service("userDetailsService")
public class UsuarioServiceImpl implements UserDetailsService {

	@Autowired
    private UsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for (Rol rol : usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		return new User(usuario.getUsername(), usuario.getPassword(), roles);
	}

}
