# Mini SGBD

Nesse mini SGBD foi usado hash para a indexação dos dados.

* O mini SGBD  possibilita a  criação de dados e salvar.

* Atualizar dados passando seu RA pois  está sendo usando como se fosse chave primária.

* Deletar Passando um ra específico.

* Visualizar todos os dados cadastrados nesse Mini SGBD.


## Aluno

* RA
* Nome
* Endereço
* celular 
* data de Nascimento

## Interface 

Quando inicia o programa irá  ver uma tela com  algumas opções do tipo criar um novo aluno, atualizar , deletar e vê todos alunos
cadastrados 
  
  <img src="telaPrincipal.png" alt="telaPrincipal" width="25000"/>
  
* caso escolha 1 que é salvar irá ver uma  tela assim:

   <img src="TelaDeSalvar.png" alt="TelaDeSalvar" width="25000"/>
   
   Obs: exemplo de cadastro
* caso escolha  2 que é para consultar um aluno terá que colocar o Ra desse aluno e irá ver uma tela assim :
   
   <img src="consultar.png" alt="consultar" width="25000"/>
   
    Obs: exemplo de cadastro
   
* Caso escolha 3 que e atualizar aluno irá ver uma tela assim :

   <img src="atualizar.png" alt="atualizar" width="25000"/>
    Obs: exemplo de cadastro
  
* Caso escolha 4 que e remover um aluno  irá ver uma tela assim:

  <img src="deletar.png" alt="remover" width="25000"/>
  
* caso 5 escolha que ver todos os alunos irá ver uma tela assim :
  
    <img src="alunosCadastrados.png" alt="alunosCadastrados" width="25000"/>





### Packages 


#### Tela
É onde e executado o programa numa class do mesmo nome, nesse package tem o minimo possivel de parte logica pois  esse packages so mostra a tela inicial.

### Funcoes 

É onde executado a maior parte da lógica de cadastrar um aluno,  remover, ver apenas um aluno e deletar aluno 


### Aluno  

 É onde estão os atributos que o aluno tem.


### exceptions 

e  onde está a exceções que tem  programa



## DicionárioHash 

É onde está toda  lógica  do  hash



### Json
 Responsável por salvar os cadastros  no programa.


### Array e tadPilha

E onde está toda a lógica de pilha.



### Esse mini SGBD foi criado usando  o  java 17 e o pacote json simples.


   
