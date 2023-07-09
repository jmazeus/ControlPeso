package mx.com.solsist.control.peso.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.com.solsist.control.peso.vo.PersonaVO;

public interface PersonaService {

	List<PersonaVO> getPersonas();
	PersonaVO guardaPersona(PersonaVO persona);
	PersonaVO actualizaPersona(PersonaVO persona);
	PersonaVO getPersonaById(int idPersona);
	PersonaVO agendaCitaPersona(int idPersona, String fechaCita);
	List<PersonaVO>  consultaPersonasByEstatus(boolean estatus);
	Page<PersonaVO>  personas(Pageable pageable);
	
}
