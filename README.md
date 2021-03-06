Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

Nove ou mais caracteres
Ao menos 1 dígito
Ao menos 1 letra minúscula
Ao menos 1 letra maiúscula
Ao menos 1 caractere especial
Considere como especial os seguintes caracteres: !@#$%^&*()-+
Não possuir caracteres repetidos dentro do conjunto
Exemplo:

<pre>
  <code>
    IsValid("") // false  
    IsValid("aa") // false  
    IsValid("ab") // false  
    IsValid("AAAbbbCc") // false  
    IsValid("AbTp9!foo") // false  
    IsValid("AbTp9!foA") // false
    IsValid("AbTp9 fok") // false 
    IsValid("AbTp9!fok") // true
  </code>
</pre>

Nota: Espaços em branco não devem ser considerados como caracteres válidos.

## Problema
Construa uma aplicação que exponha uma api web que valide se uma senha é válida.

Input: Uma senha (string).
Output: Um boolean indicando se a senha é válida.

## Aderencia a especificação
Para atender ao desafio, foi utilizada a estratégia de validação por meio de expressão regular (RegEx) para cumprir cada critério de validação estabelecido, além disso, foi utilizada a linguagem Java com o Framework Spring como principal stack.
Além da resposta booleana indicando se a senha é válida ou não, foi adicionado um array com mensagens de erro em caso de senha inválida indicando quais critérios não foram atendidos.
Para garantir a qualidade da solução, foi utilizada a estratégia de desenvolvimento orientada a testes (TDD) em cada unidade do projeto. O código foi pensado na manutenabilidade e legibilidade através de clean code e aderência aos princípios de SOLID.

## Tecnologias utilizadas
* Stack: Java 8 com Spring 2.4.4
* IDE: Spring Tool Suite 4
* Controle de versão e hospedagem de código: Git + Github
* Framework de teste Spring: JUnit, MockMvc e MockBean
* Plataforma cloud: Heroku

## Acessos
* O código fonte está disponível em https://github.com/lucaspxt/passwordapi
* A API foi disponibilizada na cloud do Heroku

### Exemplo de requisição

<blockquote>API</blockquote>
<pre>
  <code>
    - POST https://itipasswordapi.herokuapp.com/password
  </code>
</pre>

<blockquote>Body</blockquote>
<pre>
  <code>
    {
      "password": "senha desejada"
    }
  </code>
</pre>

### Exemplo de resposta

<blockquote>Senha válida</blockquote>
<pre>
  <code>
    {
      "isValid": true
    }
  </code>
</pre>

<blockquote>Senha inválida</blockquote>
<pre>
  <code>
    {
      "isValid": false,
      "errors": [
        {
            "fieldName": "password",
            "msg": "A senha deve possuir no mínimo 9 digitos."
        },
        {
            "fieldName": "password",
            "msg": "A senha não deve possuir caracteres repetidos."
        }
      ]
    }
  </code>
</pre>

