package mx.com.solsist.control.peso.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.solsist.control.peso.domain.DetallePesoEntity;
import mx.com.solsist.control.peso.repositories.DetallePesoRepository;
import mx.com.solsist.control.peso.service.DetallePesoService;
import mx.com.solsist.control.peso.utils.DateUtils;
import mx.com.solsist.control.peso.vo.DetallePesoVO;

@Service
public class DetallePesoServiceImpl implements DetallePesoService {

	@Autowired
	private DetallePesoRepository detallePesoRepository;

	@Override
	public List<DetallePesoVO> registroDetallesPeso(Integer idPersona) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public DetallePesoVO registroDetallePeso(Integer idPersona) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public DetallePesoVO guardaDetallePeso(DetallePesoVO detallePeso) {
		if(null == detallePeso.getFechaConsulta()) {
			detallePeso.setFechaConsulta(DateUtils.setMillisecondsTimeToDateToString(new Date().getTime()) );
		}
		DetallePesoEntity detallePesoEntity = setDetallePesoVOToDetallePesoEntity(detallePeso);
		return setDetallePesoEntityToDetallePesoVO(detallePesoRepository.save(detallePesoEntity));
	}

	private DetallePesoEntity setDetallePesoVOToDetallePesoEntity(DetallePesoVO detallePeso) {
		DetallePesoEntity detallePesoEntity = new DetallePesoEntity();
		BeanUtils.copyProperties(detallePeso, detallePesoEntity);
		if (null != detallePeso.getFechaConsulta()) {
			detallePesoEntity.setFechaConsulta(DateUtils.convertStringToDate(detallePeso.getFechaConsulta()));
		}

		return detallePesoEntity;
	}
	
	private DetallePesoVO setDetallePesoEntityToDetallePesoVO(DetallePesoEntity detallePesoEntity) {
		DetallePesoVO detallePesoVo = new DetallePesoVO();
		BeanUtils.copyProperties(detallePesoEntity, detallePesoVo);
		
		return detallePesoVo;
	}

}
