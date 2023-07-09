package mx.com.solsist.control.peso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.solsist.control.peso.service.DetallePesoService;
import mx.com.solsist.control.peso.vo.DetallePesoVO;

@RestController
@RequestMapping("api/v1/controlPeso")
public class ControlPesoController {

	@Autowired
	private DetallePesoService detallePesoService;

	@PostMapping("guardar")
	public ResponseEntity<DetallePesoVO> guardaDetallePeso(@RequestBody DetallePesoVO detallePeso) {
		ResponseEntity<DetallePesoVO> responseEntity = new ResponseEntity<DetallePesoVO>(
				detallePesoService.guardaDetallePeso(detallePeso), HttpStatus.OK);

		return responseEntity;
	}
	
	

}
