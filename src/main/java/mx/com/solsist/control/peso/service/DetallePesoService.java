package mx.com.solsist.control.peso.service;

import java.util.List;

import mx.com.solsist.control.peso.vo.DetallePesoVO;

public interface DetallePesoService {
	
	List<DetallePesoVO> registroDetallesPeso(Integer idPersona);
//	DetallePesoVO registroDetallePeso(Integer idPersona);
	DetallePesoVO guardaDetallePeso(DetallePesoVO detallePeso);

}
