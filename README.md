# Clin Api:
- Projeto referente a disciplina de backend III da UNIESP.  
- Clin_api é um sistema de gerenciamento de uma clínica médica. Ele fornece funcionalidades para gerenciar médicos, pacientes e consultas, utilizando a arquitetura RESTful e o framework Spring Boot.

## Pré-requisitos

- Java 11 ou superior
- Maven 3.6.0 ou superior

## Endpoints
### Paciente
#### POST /paciente: Cria um novo paciente.

Request Body: Paciente (JSON)
Response Body: Paciente (JSON)
#### GET /paciente/all: Retorna todos os pacientes.

Response Body: List de Paciente (JSON)
#### GET /paciente/id={id}: Retorna um paciente pelo ID.

Path Variable: id (Long)
Response Body: Optional<Paciente> (JSON)
#### GET /paciente/cpf={cpf}: Retorna um paciente pelo CPF.

Path Variable: cpf (String)
Response Body: Optional<Paciente> (JSON)
#### DELETE /paciente/{id}: Deleta um paciente pelo ID.

Path Variable: id (Long)
### Medico
#### POST /medico: Cria um novo médico.

Request Body: Medico (JSON)
Response Body: Medico (JSON)
#### GET /medico/all: Retorna todos os médicos.

Response Body: List de Medico (JSON)
#### GET /medico/id={id}: Retorna um médico pelo ID.

Path Variable: id (Long)
Response Body: Optional<Medico> (JSON)
#### GET /medico/crm={crm}: Retorna um médico pelo CRM.

Path Variable: crm (String)
Response Body: Optional<Medico> (JSON)
#### DELETE /medico/{id}: Deleta um médico pelo ID.

Path Variable: id (Long)
### Consulta
#### POST /consulta/cadastrar: Cria uma nova consulta.

Request Body: Consulta (JSON)
Response Body: ConsultaDTO (JSON)
#### GET /consulta/all: Retorna todas as consultas.

Response Body: List de ConsultaDTO (JSON)
#### DELETE /consulta/{id}: Deleta uma consulta pelo ID.

Path Variable: id (Long)
