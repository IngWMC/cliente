package com.pichincha.cliente.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends Persona  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clienteId;

	@NotEmpty(message = "El campo contrasenia es requerido.")
	@Column(name = "contrasenia", nullable = false, length = 70)
	private String contrasenia;

	@NotEmpty(message = "El campo estado es requerido.")
	@Pattern(regexp = "^(true|false)$", message = "El campo estado sólo puede ser: true ó false.")
	@Column(name = "estado", nullable = false)
	private String estado;

}
