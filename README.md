# Rest API - FoodHelp

## Sobre o projeto:

A fome é um problema global que afeta milhões de pessoas em todo o mundo. 
Segundo a Organização das Nações Unidas para a Alimentação e Agricultura 
(FAO), cerca de 828 milhões de pessoas foram afetadas pela fome em 2021, 
enquanto 2,3 bilhões de pessoas sofrem de insegurança alimentar moderada 
ou grave em 2021.

A escassez de alimentos é um fator que contribui para a fome, sendo que 
muitas regiões sofrem com a falta de acesso a alimentos básicos, como arroz, 
trigo e milho. Esse problema é agravado por questões como mudanças 
climáticas, conflitos armados, desigualdade social e econômica, e desastres 
naturais. 

Por isso, é fundamental que haja um esforço global no combate à fome e na 
garantia de acesso a alimentos para todas as pessoas. Medidas como a 
promoção da agricultura sustentável, o investimento em sistemas de 
armazenamento e distribuição de alimentos, a eliminação do desperdício 
alimentar e a redução das desigualdades sociais e econômicas são essenciais 
para enfrentar esse desafio. 

Com isso, o projeto “FoodHelp”, um aplicativo inovador que ofereça uma 
solução eficiente para o problema do desperdício alimentar ao conectar 
empresas, como restaurantes, padarias, supermercados e outros tipos de 
comércio, a centros de caridade e organizações sem fins lucrativos. O objetivo 
é garantir que os alimentos não sejam desperdiçados, mas sim direcionados 
para aqueles que mais precisam. 

O aplicativo permite que empresas de diferentes setores se cadastrem 
facilmente, fornecendo informações, como nome, localização, horário de 
funcionamento e tipo de negócio. Isso inclui estabelecimentos que lidam com 
alimentos. Após o cadastro, as empresas podem fotografar os alimentos que 
sobraram ou estão próximos da data de validade. Com um recurso de 
inteligência artificial, pela detecção de imagens, o aplicativo é capaz de 
identificar os alimentos. As fotos dos alimentos e suas informações são 
exibidas no aplicativo, onde as organizações de caridade e centros de apoio 
podem visualizá-las. As empresas têm acesso a uma lista atualizada de
alimentos disponíveis para doação. 

Com uma plataforma de comunicação entre as empresas e as instituições de 
caridade, isso permite um planejamento sobre as negociações sobre o local de 
retirada, horário, entre outros detalhes logísticos que poderão ser tratados. A 
comunicação direta facilita a colaboração, evitando desperdício devido a 
problemas de logística.

## Instalação e execução da API

A API foi desenvolvida usando  Java 17 e com o framework Spring + Gradle e banco de dados relacional Oracle SQL.
O primeiro passo é buildar a aplicação. Abra um prompt de comando na pasta raiz do projeto e execute o comando:
```console
admin:~$ gradle build
admin
```
Se o seu Java e Gradle estiverem configurados corretamente, o projeto deve buildar sem problemas e estar pronto para a inicialização.
O próximo passo é executar o método Main presente na classe ApiApplication que se encontra no caminho *src/main/java/com/gs/api*.

O projeto contém um swagger, que é um console que roda junto com o programa e serve para testes. Ele oferece uma interface gráfica html com todos os endpoints e seus respectivos *json* formatados já com o os campos necesários para cada endpoint e o tipo de dado que ele precisa.

A configuração do banco de dados é feita pelo arquivo application.properties. Lá é possível que mudar o login, senha e endereço do seu banco de dados Oracle.

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


#### GET /restaurantes  
Endpoint que retorna lista com todos os restaurantes listados por ordem de cadastro. Não pede *json*, pede dois parametros: email (*String*) e senha (*String*).  

#### GET /restaurantes/busca  
Endpoint que retorna restaurante a partir do nome. Não pede *json*, pede o parametro nome (*String*)

#### POST /alimentos  
Endpoint responsável pelo cadastro de alimentos. Recebe o id do restaurante que faz a doação e uma lista de strings com os alimentos.  
*Json*:  
  {  
  "tags": [  
    "string"  
  ],  
  "restauranteDoadorId": 0  
}


#### GET /alimentos  
Endpoint que retorna lista com todos os alimentos listados por ordem de cadastro. Não pede *json*.  


#### DELETE /alimentos  
Endpoint responsável pela exclusão lógica de alimentos. Usado assim que um alimentos é escolhido por um usuário. Muda o atributo *ativo* do alimento de *true* pra *false*. Não necessita de *json*, recebe um paramentro *Id*.  
