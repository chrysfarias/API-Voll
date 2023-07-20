package med.voll.api.endereco;
import med.voll.api.medico.Medico;

public record
DadosListagemEnderecosMedicos(String logradouro, String bairro, String cep, String numero,String complemento,
		String cidade,String uf) {
	
	public DadosListagemEnderecosMedicos(Medico medicoEnderecos) {
		this(medicoEnderecos.getEndereco().getLogradouro(), medicoEnderecos.getEndereco().getBairro(),
				medicoEnderecos.getEndereco().getCep(), medicoEnderecos.getEndereco().getNumero(),
				medicoEnderecos.getEndereco().getComplemento(),
				medicoEnderecos.getEndereco().getCidade(), medicoEnderecos.getEndereco().getUf());	 
	}

}
