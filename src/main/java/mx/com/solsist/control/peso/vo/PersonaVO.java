package mx.com.solsist.control.peso.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonaVO {
	
	private Long idPersona;
	private String nombres;
	private String apPaterno;
	private String apMaterno;
	private String telefonoFijo;
	private String telefonoCel;
	private String correo;
	private String genero;
	private String fechaAlta;
	private String fechaModificacion;
	private String fechaProximaCita;
	private boolean estatus;
	private String contactoEmergencia;
	private String domicilio;
	private Double estatura;
}
