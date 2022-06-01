
<h1>SeniorLabs Challenge</h1>
<p>Repositório utilizado para armazenar o código fonte do desafio da SeniorLabs</p>


<h2>Descrição geral do projeto:</h2>

<h1>Tecnologias :</h1>

+ <h4>📌 Java</h4>
+ <h4>📌 Spring Framework</h4>   


<h1>Problema :</h1>

+ <h4>O problema vinha em cima de algo amplamente utilizado por empresas no Brasil, a marcação de ponto, algo utilizado para que os colaboradores realizem diariamente seu registro de horas.  Esse sistema de morcação de ponto vem sendo feito por meio de um sistema legado, que tem um tempo de resposta demorado, e por já ser um sistema antigo pode ser sobrecarregado de tantas requisições em um curto período. </h4>

<h1> O que foi desenvolvido: </h1>

+ <h4>Desenvolvi um sistema Java utilizando o Spring Framework, e dependências de dentro do seu ecosistema. Esse sistema utilizada da arquitetura REST, e como era necessário de comunicar com um sistema legado por meio de JSON fui atrás de uma dependência que facilitasse essas requisições, para não ter que usar métodos 'brutos' como o OkHttp e o HttpClient, e assim encontrei o OpenFeign, uma biblioteca que facilita muito essas requisições Http com outras sistemas, tudo isso sendo feito com uma uníca classe. Assim desenvolvi uma API que recebe como JSON as informações como "employeeId" e "employerId" e até mesma o horário que ele bateu o ponto "includedAt", porém se essa informação não for preenchida no JSON, ela é preenchida no Back-End como o horário do momento. Essas informações são salvas num Banco de Dados PostgreSQL, criei esse banco de dados para poder consultar todos os horários de pontos batidos por tal funcionário.</h4>

<h1>O que faltou desenvolver: </h1>

+ <h4>Não entendi muito bem como resolver o problema de sobrecarregamento do sistema legado, pesquisei formas de cuidar desse problema porém não consegui encontrar meios eficientes.</h4>

<h2>Execução do sistema</h2>

<ol>
  <li>Instale o JDK do Java 11</li>
  <li>Instale uma IDE para subir o sistema, eu utilizei o IntelliJ</li>
  <li>Importe o projeto como uma Maven, para instalar as dependcências do Spring, e outras que adicionei no projeto</li>
  <li>Se não estiver utilizando o IntelliJ será necessário instalar o Lombok dentro de sua IDE</li>
  <li> Rode o arquivo SeniorlabsChallengeApplication, que irá subir a API</li>
</ol>

<h2>API :</h2>

<p>A URL que deve ser chamada do sistema legado é a seguinte: 
* http://localhost:8080/v1/clocking/
ou
* https://seniorlabs-challenge.herokuapp.com/v1/clocking/

Payload de exemplo para a requisição: 

```json
{"includedAt":"2021-03-15 15:10:00", "employeeId": 123, "employerId": 999} 
```

Onde: 

* *includedAt* é a data e hora que ocorreu a marcação de ponto 
* *employeeId* é o código do funcionário que fez a marcação de ponto 
* *employerId* é o código da empresa em que o funcionário trabalha </p>

<p>O campo "includedAt" não precisa ser necessáriamente preenchido, se não for será preenchido no Back-End com o horáriodo momento </p>

<p> Se você quiser buscar todas as marcações de pontos de tal funcionário é necessario mandar uma requisição para a url acima com /{employeeId} que irá retornar </p>