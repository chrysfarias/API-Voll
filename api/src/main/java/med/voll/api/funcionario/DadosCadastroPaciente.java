package med.voll.api.funcionario;

import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cep, DadosEndereco endereco) {

}
