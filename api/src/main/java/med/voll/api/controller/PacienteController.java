package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.funcionario.DadosCadastroPaciente;
import med.voll.api.funcionario.Paciente;
import med.voll.api.funcionario.PacienteRepository;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	public void cadastrarPacientes(@RequestBody DadosCadastroPaciente dados ) {
	
	repository.save(new Paciente(dados));
		
		
		
	}

}
