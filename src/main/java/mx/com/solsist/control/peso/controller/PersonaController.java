package mx.com.solsist.control.peso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.solsist.control.peso.domain.PersonaEntity;
import mx.com.solsist.control.peso.service.PersonaService;
import mx.com.solsist.control.peso.vo.PersonaVO;

@RestController
@RequestMapping("api/v1/persona")
@CrossOrigin(origins = "*")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/personas")
	public ResponseEntity<Page<PersonaVO>> paginas(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "idPersona") String order,
			@RequestParam(defaultValue = "true") boolean asc
			) {
		Page<PersonaVO> personas = personaService.personas(PageRequest.of(page, size, Sort.by(order)));
		
		if(!asc) {
			personas = personaService.personas(PageRequest.of(page, size, Sort.by(order).descending()));
		}
		return new ResponseEntity<Page<PersonaVO>>(personas, HttpStatus.OK);
	}

	@GetMapping("listar")
	public List<PersonaVO> getPersonas() {
		return personaService.getPersonas();
	}

	@PostMapping("guardar")
	public PersonaVO guardaPersona(@RequestBody PersonaVO persona) {
		persona.setEstatus(true);
		PersonaVO personaSaved = personaService.guardaPersona(persona);

		return personaSaved;
	}

	@PutMapping("actualiza")
	public PersonaVO actualizaPersona(@RequestBody PersonaVO persona) {
		PersonaVO personaUpdated = personaService.actualizaPersona(persona);

		return personaUpdated;
	}

	@GetMapping("busca/{id}")
	public PersonaVO obtenPersona(@PathVariable Integer id) {
		return personaService.getPersonaById(id);
	}

	@PutMapping("agendaCita")
	public PersonaVO agendaProximaCita(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "fechaCita") String fechaCita) {
		return personaService.agendaCitaPersona(id, fechaCita);
	}
}
