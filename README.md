# Rest API - FoodHelp

## Sobre o projeto:

## Instalação e execução da API

A API foi desenvolvida usando  Java 17 e com o framework Spring + Gradle.
O primeiro passo é buildar a aplicação. Abra um prompt de comando na pasta raiz do projeto e execute o comando:
```console
admin:~$ gradle build
admin
```
Se o seu Java e Gradle estiverem configurados corretamente, o projeto deve buildar sem problemas e estar pronto para a inicialização.
O próximo passo é executar o método Main presente na classe ApiApplication que se encontra no caminho *src/main/java/com/gs/api*.

O projeto contém um swagger, que é um console que roda junto com o programa e serve para testes. Ele oferece uma interface gráfica html com todos os endpoints e seus respectivos *json* formatados já com o os campos necesários para cada endpoint e o tipo de dado que ele precisa. 

### Lista de ENDPOINTS:  


#### POST /usuarios
Endpoint responsável pelo cadastro de novos usuário. Contém validação de email (precisa conter "@") e de CNPJ (14 digitos).  
*Json*:  
  {  
  "nome": "string",  
  "email": "string",  
  "senha": "string",  
  "cnpj": "string",  
  "endereco": {  
    "cep": "string",  
    "logradouro": "string",  
    "numero": "string",  
    "uf": "AC",  
    "complemento": "string"  
  }
}

#### POST /usuarios/login  
Endpoint responsável pelo login de usuários. Não funciona pede um *json*, mas sim 2 parametros: email e senha, e busca no banco por usuários cadastrados com o mesmo login e senha informados.  


#### POST /restaurantes/  
Endpoint responsável pelo cadastro de novos usuário. Contém validação de email (precisa conter "@") e de CNPJ (14 digitos).  
*Json*:  
  {  
  "nome": "string",  
  "email": "string",  
  "senha": "string",  
  "cnpj": "string",  
  "endereco": {  
    "cep": "string",  
    "logradouro": "string",  
    "numero": "string",  
    "uf": "AC",  
    "complemento": "string"  
  }  
}  
  
#### POST /restaurantes/login  
Endpoint responsável pelo login de restaurantes. Não funciona pede um *json*, mas sim 2 parametros: email e senha, e busca no banco por restaurantes cadastrados com o mesmo login e senha informados.  


### GET /restaurantes  
Endpoint que retorna lista com todos os restaurantes listados por ordem de cadastro. Não pede *json*.  


#### POST /alimentos  
Endpoint responsável pelo cadastro de alimentos. Recebe o id do restaurante que faz a doação e uma lista de strings com os alimentos.  
*Json*:  
  {  
  "tags": [  
    "string"  
  ],  
  "restauranteDoadorId": 0  
}


### GET /alimentos  
Endpoint que retorna lista com todos os alimentos listados por ordem de cadastro. Não pede *json*.  


### DELETE /alimentos  
Endpoint responsável pela exclusão lógica de alimentos. Usado assim que um alimentos é escolhido por um usuário. Muda o atributo *ativo* do alimento de *true* pra *false*. Não necessita de *json*, recebe um paramentro *Id*.  
