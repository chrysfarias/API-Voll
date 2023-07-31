package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.experimental.var;
import med.voll.api.endereco.DadosListagemEnderecosMedicos;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
		
		repository.save(new Medico(dados));
	}
	
	
	@GetMapping
	public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size=10, sort= {"nome"}) org.springframework.data.domain.Pageable	 paginacao){
		return repository.findAll(paginacao).map(DadosListagemMedico:: new);
		
	}
	
	@GetMapping("/listarEnderecos")
	public List<DadosListagemEnderecosMedicos> listarEnderecosDosMedicos(){
		return repository.findAll().stream().map(DadosListagemEnderecosMedicos:: new).toList();
		
	}
	
	
	@GetMapping("/listarTudo")
	public List<Medico> listarMedicosComTodosOsAtributos(){
		return repository.findAll();
	}
	

	@PutMapping
	@Transactional
	public void atualizarMedicos(@RequestBody @Valid DadosAtualizacaoMedico dados) {
		
		Medico medico = new Medico();
		medico = repository.getReferenceById(dados.id());
		medico.atualizarInformacoes(dados);
		
	}
	
	
}
