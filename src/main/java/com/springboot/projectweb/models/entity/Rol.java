package com.springboot.projectweb.models.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_rol")
public class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;
	private String nombre;

	private static final long serialVersionUID = 1L;
}
