package mx.com.solsist.control.peso.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.solsist.control.peso.domain.PersonaEntity;
import mx.com.solsist.control.peso.repositories.PersonaRepository;
import mx.com.solsist.control.peso.service.PersonaService;
import mx.com.solsist.control.peso.utils.DateUtils;
import mx.com.solsist.control.peso.vo.PersonaVO;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaRepository personaRepository;
	
	private final static String FORMAT_DATE_EMPTY = "--/--/---- --:--";

	SimpleDateFormat sdfSave = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Override
	public List<PersonaVO> getPersonas() {
		List<PersonaEntity> personasEntity = (List<PersonaEntity>) personaRepository.findAll();
		List<PersonaVO> personas = new ArrayList<>();
		for (PersonaEntity personaEntity : personasEntity) {
			PersonaVO persona = new PersonaVO();
			persona = castPersonaEntityToPersona(personaEntity);
			personas.add(persona);
		}

		return personas;
	}
	
	

	@Override
	public PersonaVO guardaPersona(PersonaVO persona) {

		if (null != persona) {
			setFechaAltaToPersona(persona);
			PersonaEntity personaEntity = castPersonaToPersonaEntity(persona);

			personaEntity = personaRepository.save(personaEntity);
			return castPersonaEntityToPersona(personaEntity);
		}
		return null;
	}

	private PersonaVO castPersonaEntityToPersona(PersonaEntity personaEntity) {
		PersonaVO persona = new PersonaVO();
		if (null != personaEntity.getIdPersona()) {
			persona.setIdPersona(personaEntity.getIdPersona());
			persona.setNombres(personaEntity.getNombres());
			persona.setApPaterno(personaEntity.getApPaterno());
			persona.setApMaterno(personaEntity.getApMaterno());
			persona.setTelefonoFijo(personaEntity.getTelefonoFijo().toString());
			persona.setTelefonoCel(personaEntity.getTelefonoCel().toString());
			persona.setCorreo(personaEntity.getCorreo());
			if(personaEntity.getFhAlta() != null) {
				persona.setFechaAlta(DateUtils.setMillisecondsTimeToDateToString(personaEntity.getFhAlta().getTime()));
			} else {
				persona.setFechaAlta(FORMAT_DATE_EMPTY);
			}
			
			persona.setGenero(personaEntity.getGenero());
			persona.setEstatus(personaEntity.isEstatus());
			if (null != personaEntity.getFechaModificacion()) {
				persona.setFechaModificacion(
						DateUtils.setMillisecondsTimeToDateToString(personaEntity.getFechaModificacion().getTime()));
			} else {
				persona.setFechaModificacion(FORMAT_DATE_EMPTY);
			}

//			if (null != personaEntity.getFechaProximaCita()) {
//				String fechaCita = DateUtils.setMillisecondsTimeToDateToString(personaEntity.getFechaProximaCita().getTime());
//				persona.setFechaProximaCita(fechaCita);
//			} else {
//				persona.setFechaProximaCita(FORMAT_DATE_EMPTY);
//			}
		}
		System.out.println(persona);
		return persona;
	}

	private PersonaEntity castPersonaToPersonaEntity(PersonaVO persona) {
		PersonaEntity personaEntity = new PersonaEntity();
		BeanUtils.copyProperties(persona, personaEntity);
		if (null != persona.getFechaAlta()) {
			try {
				personaEntity.setFhAlta(new Timestamp(sdfSave.parse(persona.getFechaAlta()).getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if(!persona.getContactoEmergencia().equals("")) {
			personaEntity.setContactoEmergencia(Long.valueOf(persona.getContactoEmergencia()));
		}

		return personaEntity;
	}

	private void setFechaAltaToPersona(PersonaVO persona) {
		if (null == persona.getFechaAlta()) {
			persona.setFechaAlta(sdfSave.format(new Date()));
		}

		if (null == persona.getFechaAlta()) {
			persona.setFechaAlta(sdfSave.format(new Date()));
		}
	}

	@Override
	public PersonaVO actualizaPersona(PersonaVO persona) {
		if (null != persona) {
			setFechaAltaToPersona(persona);
			PersonaEntity personaEntity = castPersonaToPersonaEntity(persona);

			personaEntity = personaRepository.save(personaEntity);
			return castPersonaEntityToPersona(personaEntity);
		}

		return null;
	}

	@Override
	public PersonaVO getPersonaById(int idPersona) {

		@SuppressWarnings("static-access")
		PersonaEntity personaEntity = personaRepository.findById(idPersona).get();
		return castPersonaEntityToPersona(personaEntity);
	}

	@Override
	public PersonaVO agendaCitaPersona(int idPersona, String fechaCita) {
		PersonaEntity personaEntity = personaRepository.findById(idPersona).get();
		//personaEntity.setFechaProximaCita(DateUtils.convertStringToDate(fechaCita));
		personaRepository.save(personaEntity);
		return castPersonaEntityToPersona(personaEntity);
	}



	@Override
	public List<PersonaVO> consultaPersonasByEstatus(boolean estatus) {
		List<PersonaEntity> personasEntity = (List<PersonaEntity>) personaRepository.findByEstatus(estatus);
		List<PersonaVO> personas = new ArrayList<>();
		for (PersonaEntity personaEntity : personasEntity) {
			PersonaVO persona = new PersonaVO();
			persona = castPersonaEntityToPersona(personaEntity);
			personas.add(persona);
		}

		return personas;
	}



	@Override
	public Page<PersonaVO> personas(Pageable pageable) {

		Page<PersonaVO> personasPage = personaRepository.findAll(pageable).map(this::convertToPersonaVOPage);

		return personasPage;
	}
	
	
	private PersonaVO convertToPersonaVOPage(PersonaEntity personsPageEntity){
		List<PersonaVO> personas = new ArrayList<>();
		
		PersonaVO persona = new PersonaVO();
		persona = castPersonaEntityToPersona(personsPageEntity);
		personas.add(persona);
		
		return persona;
	}

}
