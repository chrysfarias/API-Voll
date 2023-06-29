package med.voll.api.medico;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;


public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,DadosEndereco endereco) {

	 public Medico toMedico() {
		
		 Medico medico = new Medico();
		 medico.setNome(nome);
		 medico.setCrm(crm);
		 medico.setEmail(email);
		 medico.setEspecialidade(especialidade);
		 
		 Endereco endereco = new Endereco();
		 endereco.setBairro(this.endereco().bairro());	
		 endereco.setCep(this.endereco.cep());
		 endereco.setCidade(this.endereco.cidade());
		 endereco.setComplemento(this.endereco.complemento());
		 endereco.setLogradouro(this.endereco.logradouro());
		 endereco.setNumero(this.endereco.numero());
		 endereco.setUf(this.endereco.uf());
			 
		 return medico;
		
				
	 } 
	 
		 
	
	    
}

