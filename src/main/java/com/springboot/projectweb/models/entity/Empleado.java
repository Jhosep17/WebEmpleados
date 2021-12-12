package com.springboot.projectweb.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_empleado")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	@NotEmpty(message = "*nombre es requerido")
	private String nombre;
	@NotEmpty(message = "*apellido es requerido")
	private String apellido;
	@NotEmpty(message = "*dni es requerido")
	private String dni;
	@NotEmpty(message = "*celular es requerido")
	private String celular;
	@NotNull(message = "*campo requerido")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaInicio;
	@NotNull(message = "*campo requerido")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaNacimiento;
	@Temporal(TemporalType.DATE)
	private Date createAt;
	@Temporal(TemporalType.DATE)
	private Date updateAt;
	private int createById;
	private int updateById;

	private static final long serialVersionUID = 1L;

}
