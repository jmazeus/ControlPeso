package mx.com.solsist.control.peso.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "detalle_peso")
@Data
public class DetallePesoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id_control_peso")
	private Integer idControlPeso;

	@Column(name = "fecha_consulta")
	private Date fechaConsulta;
	@Column(name = "peso")
	private Double peso;
	@Column(name = "talla")
	private Integer talla;
	@Column(name = "altura")
	private Double altura;
	@Column(name = "medida_abdomen_alto")
	private Double medidaAbdomenAlto;
	@Column(name = "medidaAbdomen_medio")
	private Double medidaAbdomenMedio;
	@Column(name = "medidaAbdomen_bajo")
	private Double medidaAbdomenBajo;
	@Column(name = "medida_pecho")
	private Double medidaPecho;
	@Column(name = "medida_brazo_derecho")
	private Double medidaBrazoDerecho;
	@Column(name = "medida_brazo_izquierdo")
	private Double medidaBrazoIzquierdo;
	@Column(name = "medida_pierna_derecha")
	private Double medidaPiernaDerecha;
	@Column(name = "medida_pierna_izquierda")
	private Double medidaPiernaIzquierda;
	@Column(name = "medida_cintura")
	private Double medidaCintura;
	@Column(name = "medida_cadera")
	private Double medidaCadera;
	@Column(name = "id_persona")
	private Integer idPersona;
	@Column(name = "IMC")
	private Double imc;
	@Column(name = "porcentaje_grasa")
	private Double porcentajeGrasa;
	@Column(name = "porcentaje_musculo")
	private Double porcentajeMusculo;

}
