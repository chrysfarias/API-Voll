alter table pacientes
	add constraint unique_email unique (email),
	add constraint unique_cpf unique (cpf);