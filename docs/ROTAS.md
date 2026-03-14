# Documentação de Rotas

## API principal (Spring Boot)

Base URL local: `http://localhost:8080`

| Método | Rota | Descrição | Body |
|---|---|---|---|
| `GET` | `/clientes` | Lista todos os clientes | Não |
| `POST` | `/clientes` | Cria um novo cliente | Sim |

### Exemplo: POST /clientes

```json
{
  "cpf": "12345678900",
  "nome": "João",
  "sobrenome": "Silva"
}
```

## Rotas mockadas (WireMock)

Base URL local: `http://localhost:8081`

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/clientes` | Lista mockada de clientes |
| `GET` | `/acomodacoes` | Lista mockada de acomodações |
| `GET` | `/clientes_com_reservas-ativas` | Lista mockada de clientes com reservas ativas |
| `GET` | `/reservas` | Lista mockada de reservas |
| `POST` | `/reservas` | Cria reserva mockada |
