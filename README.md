
## **Sobre o projeto**

O projeto foi desenvolvido usando a JDK 11 com spring boot.  Para executar o projeto basta rodar o jar gerado no processo de package do maven.  
Foi utilizado lombok portanto é necessário instalar o plugin da mesma na IDE. 

## **Sobre a solução**

Ao carregar a aplicação o bean XmlLoader carrega o arquivo xml para o banco de dados H2 em memória.  Uma api restfull disponibiliza uma lista de documentos paginados no **/documento**.  
Por questão de tempo e conveniência a response é gerada serializando as próprias entidades, o uso de DTOs seria mais apropriado.  

A aplicação está disponível em [https://slc-application.herokuapp.com](https://slc-application.herokuapp.com)
