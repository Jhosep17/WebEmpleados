package com.springboot.projectweb.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String username;
	private String password;
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Rol> roles;

	private static final long serialVersionUID = 1L;
}
