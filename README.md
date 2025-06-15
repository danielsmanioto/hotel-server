# hotel-server

aplicacao hotel-server é responsavel por ser a api do sistema de hotel.
sistema de hotel é uma aplicacao client server.

# rotas 
- reservas
- reservar
- acomodacoes
- clientes
- clientes-com_-reservas-ativas

# requisitos tecnicos
- rotas localmente no docker via containers 
- banco de dados nosql mongo db (devido estudos e poder de escala)
- esteira de ci/cd github actions deve executar os teses quando push na main
 
 # modelagem de dados

- acomodacoes (id, tipo, valor diaria,, numero_quarto) 
- reservas ( id, numero_quarto, data_reservada, data_cadastro, status, id_cliente)
-  clientes ( id, cpf, nome, sobrenome)
 
