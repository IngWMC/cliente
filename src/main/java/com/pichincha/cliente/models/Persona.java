package com.pichincha.cliente.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Persona {

	@NotEmpty(message = "El campo nombre es requerido.")
	@Column(name = "nombre", nullable = false, length = 150)
	private String nombre;

	@NotEmpty(message = "El campo genero es requerido.")
	@Pattern(regexp = "^(M|F)$", message = "El campo genero sólo puede ser: M ó F.")
	@Column(name = "genero", nullable = false)
	private String genero;

	@NotNull(message = "El campo edad es requerido.")
	@Column(name = "edad", nullable = false)
	private Integer edad;

	@NotEmpty(message = "El campo dni es requerido.")
	@Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres.")
	@Column(name = "dni", nullable = false, length = 8, unique = true)
	private String dni;

	@NotEmpty(message = "El campo direccion es requerido.")
	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;

	@NotEmpty(message = "El campo telefono es requerido.")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres.")
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;

}
