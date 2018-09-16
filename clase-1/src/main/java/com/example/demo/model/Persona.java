package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"dni"})
public class Persona {
	
	@NonNull @Getter @Setter  private String dni;
	@NonNull @Getter @Setter  private String nombre;
	@NonNull @Getter @Setter  private String apellido;
	
}
