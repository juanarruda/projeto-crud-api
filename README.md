## Configuracao de ambiente

O codigo foi projetado no intellij, em conjunto com o `projeto-crud-estatico`. Para rodar o programa, é necessário utilizar
o tomcat `8.5.78` e o java `1.8`.
Além disso, recomendo utilizar a extensão CORS unblock no Chrome para realizar as chamadas.

## Caminho do contexto

Para configurar o contexto, é necessario alterar o aplication context do tomcat para `/projeto-crud-api`.

## Banco de dados
Foi utilizado o banco MySql 8.0.28 e os scripts estão na pasta `src/main/resources`.

## Desafio
O desafio foi utilizar o java sem frameworks para construir um servidor backend que realiza um CRUD de clientes com login
em uma semana.

## Resultados
Não utilizar frameworks pra criar o servidor causou alguns problemas, o mais complicado foi não utilizar framework ORM 
como hibernate para conectar com o banco, o mysql-connector-java causa um timeout com qualquer consulta que não seja um
select, sendo que os comandos de insert e delete desse programa foram testados diretamente no banco e funcionam sem
problemas.

##O que foi feito
Atualmente, o projeto consegue listar o formulário de cliente e fazer a listagem de todos os clientes na tabela,
as operações de insert e delete foram feitas no código, mas travam a conexão e não funcionam.
