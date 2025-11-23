# A3-Java-Pedidos
Sistema de pedidos para lanchonete, usando Java e SpringBoot.

Para usar o sistema, é necessário o __VSCode__ com o pack de extensões para Java (_Extension Pack for Java, by vscjava_
), __Java JDK 21__ instalado e adicionado ao _path_ do sistema, o __Maven__ instalado, o __XAMPP__ instalado, e o Python instalado (opcional) para o servidor web local.

## Passo-a-Passo

1 - Abra o XAMPP e dê _Start_ no Modulo Apache e MySQL; quando estiverem funcionando, no modulo MySQL, clique em _Admin_.

2 - No painel lateral esquerdo, onde está escrito phpMyAdmin, terá um ícone de um banco de dado, com um símbolo de + verde, escrito 'Novo' ao lado, clique nele.

3 - No campo de texto, logo abaixo de onde está escrito 'Criar banco de dados', insira o nome do banco, que deverá ser 'lanchonete', e depois, clique em criar.

4 - Volte ao menu, ou clicando no ícone de casa no canto esquerdo, ou clicando em phpMyAdmin, e no canto superior, mais ou menos no centro, clique em 'Contas de usuário'; role para baixo, até chegar em 'Novo', e clique em 'Adicionar conta de usuário'. Onde está escrito 'Nome de usuário:', você inserir o nome 'grupo'; em 'Senha:' e 'Re-digite:' você deve inserir a senha 'BolinhaDeNeve345' (ou também crie com outras credenciais de usuário e informe isso no arquivo _application.properties_). Depois, role para baixo, e em 'Privilégios globais', clique em 'Marcar todos', role para baixo, e clique em 'Executar'.

5 - Abra a pasta do projeto no VSCODE, abra um novo terminal, digite __mvn clean install__, e dê enter.

6 - Depois do projeto ser compilado, vá em _A3-Java-Pedidos\src\main\java\com\github\a3\pedidos_, e clique em _Run_ no arquivo 'LanchoneteApplication.java'.

7 - Espere um tempo, e para saber se funcionou, abra o Swagger com esse link: [http://localhost:8080/swagger-ui/index.html ](http://localhost:8080/swagger-ui/index.html )

8 - A API já está funcionando, mas caso queira usar a interface WEB, acesse o diretório _A3-Java-Pedidos\src\main\resources\static_ pelo terminal, e execute o servidor Python com o comando __python -m http.server__ , caso você não tenha Python instalado em seu computador, use o comando __jwebserver -p 8000 -b 127.0.0.1__ . Depois abra no navegador: [http://localhost:8000](http://localhost:8000)

9 - Para usar a área de administração da interface web, é necessário ter uma conta de gerente, para poder criar outras contas de tipos diferentes, para isso, se conecte no banco usando o DBeaver, HeidiSQL, ou outro programa. Abra o banco, e faça a seguinte consulta SQL:

    INSERT INTO `funcionario` (`cargo`, `identificador`, `nome`, `senha_hash`) VALUES ('GERENTE', 'L1', 'Leão', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');

Após isso, faça login com o identificador __L1__ e a senha __123__ .

## Requisitos do projeto

### Funcionais

- Possibilitar que se faça o pedido de um ou mais itens
- Cadastro, Edição e Exclusão de Itens do Cardapio
- Deve haver um cardápio
- Carrinho de Compras (Adicionar, remover e visualizar)
- Deve ser possível filtrar os itens pela sua categoria
- Cadastro de um produto com diferentes tamanhos e preços
- Integração com sistema de pagamento (__não implementado__)
- Mudar o estado do pedido (aberto, em preparo, concluído, entregue)
- Cadastro de funcionário
- Login de funcionário
- Filtrar pedidos pelo seu estado
- Poder esconder um item do cardápio, e também marcar ele como esgotado
- Deve ser possível criar, editar e apagar categorias
- Cálculo de frete (__não implementado__)

### Não funcionais

- Funcionar pelo navegador
- Ter interface responsiva
- Ter interface simples e intuitiva
- Bom desempenho
- Suportar mais de um usuário simultaneamente
- Acessibilidade (__não implementado__)
- API segura (__não implementado__)


## Gestão de projeto

Utilizamos o [_Canva_](https://www.canva.com/design/DAG2jIkMvb4/O9Bmx-5vT2mXhxYhOZAezQ/view?utm_content=DAG2jIkMvb4&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=h4a1eeda631) para modelar o básico do sistema, mas a maior parte das decisões foi tomada pelo _WhatsApp_ e durante reuniões no Jitsi _Meet_, também usamos o [Trello](https://zupimages.net/up/25/47/c0zi.png), mas bem pouco.

## Gravação do funcionamento

Pode ser conferida dentro da pasta /videos
