package mx.com.solsist.control.peso.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "persona")
@Data
public class PersonaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id_persona")
	private Long idPersona;

	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;

	@Column(name = "apellido_paterno", nullable = false, length = 50)
	private String apPaterno;

	@Column(name = "apellido_materno", nullable = true, length = 50)
	private String apMaterno;

	@Column(name = "fecha_nacimiento", nullable = false)
	private Timestamp fhNacimiento;
	
	@Column(nullable = false)
	private int edad;
	
	@Column(nullable = false)
	private Double estatura;
	
	@Column(name = "peso_inicial", nullable = false)
	private Double pesoInicial;
	
	@Column(nullable = false)
	private String genero;
	
	@Column(nullable = false, length = 150)
	private String domicilio;
	
	@Column(nullable = false)
	private String correo;
	
	@Column(nullable = false)
	private Number telefonoFijo;

	@Column(name = "estatus")
	private boolean estatus;

	@Column(name = "telefono_cel", nullable = false)
	private Number telefonoCel;

	@Column(name = "fecha_modificacion", nullable = true)
	private Timestamp fechaModificacion;

	@Column(name = "contacto_emergencia", nullable = false)
	private Number contactoEmergencia;
	
	@Column(name = "fecha_alta", nullable = false)
	private Timestamp fhAlta;

}
