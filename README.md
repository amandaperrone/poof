# POO1-AF
Código desenvolvido para a avaliação final da matéria Programação Orientada a Objeto I Lab

---

Desenvolva uma aplicação do tipo API Web RestFul que permita gerenciar reservas de veículos. A aplicação deverá permitir:

1. Gerenciar Veículos-CRUD(Create-Read-Update-Delete)
* Código
* Modelo
* Valor diária.
 
2. Gerenciar Clientes e listar as reservas de um Cliente-CRUD(Create-Read-Update-Delete)
* Código
* Nome
* Endereço
* CPF

3. Fazer uma Reserva de um veículo por um cliente. A reserva deverá ter:
* Tem um número
* Cliente deverá existir.
* Veículo deverá existir.
* Data de Início (Deverá ser maior que a data do sistema). Não pode começar no Domingo.
* Data de Fim (Deverá ser maior que a data de Início). Não existe entrega no Domingo.
* O total da reserva deverá ser calculado.
* Um veículo pode ser reservado várias vezes, porém somente em períodos/datas diferentes.
* O caminho para criar uma reserva é: POST de clientes/{id-cliente}/veiculos/{id-veiculo}

4. Listar uma reserva pelo número.

5. Listar as reservas de um cliente.

6. Listar as reservas de um veículo
 

Itens Obrigatórios:

Projeto deverá estar em um repositório GIT e enviar o link.
Validar todos os dados de cadastro e alteração. Usar @Valid e Constrains
Usar o padrão DTO em pelo menos um recurso.
Publicar a aplicação no Heroku.
