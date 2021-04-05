# Password API
Desafio lançado pelo Iti como parte do processo de seleção para engenheiro(a) software backend.

Detalhes do desafio: https://github.com/thiagoaos/itau-test

## Aderencia a especificação
Para atender ao desafio, foi utilizada a estratégia de validação por meio de expressão regular (RegEx) para cumprir cada critério de validação estabelecido, além disso, foi utilizada a linguagem Java com o Framework Spring como principal stack.
Para garantir a qualidade da solução, foi utilizada a estratégia de desenvolvimento orientado a testes (TDD) em cada unidade do projeto. O código foi pensado na manutenabilidade e legibilidade através de clean code e aderência aos princípios de SOLID.

## Tecnologias utilizadas
* Stack: Java 8 com Spring 2.4.4
* IDE: Eclipse com Spring Tool Suite 4
* Controle de versão e hospedagem de código: Git + Github
* Framework de teste Spring: JUnit, MockMvc e MockBean
* Plataforma cloud: Heroku

## Acessos
* O código fonte está disponível em https://github.com/lucaspxt/passwordapi
* A API foi disponibilizada na cloud do Heroku https://itipasswordapi.herokuapp.com/

### Endpoint
<pre>
  <code>
    - Production POST https://itipasswordapi.herokuapp.com/password
    - Local POST http://localhost:8000/password
  </code>
</pre>
