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
public class DetallePesoVO {
	private Integer idControlPeso;
	private String fechaConsulta;
	private Double peso;
	private Integer talla;
	private Double altura;
	private Double medidaAbdomenAlto;
	private Double medidaAbdomenMedio;
	private Double medidaAbdomenBajo;
	private Double medidaPecho;
	private Double medidaBrazoDerecho;
	private Double medidaBrazoIzquierdo;
	private Double medidaPiernaDerecha;
	private Double medidaPiernaIzquierda;
	private Double medidaCintura;
	private Double medidaCadera;
	private Integer idPersona;
	private Double imc;
	private Double porcentajeGrasa;
	private Double porcentajeMusculo;
}
