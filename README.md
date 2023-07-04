## Projeto de Controle de Clientes e Movimentações Financeiras

Este é um projeto de controle de clientes e movimentações financeiras, desenvolvido em Java.
<br>O objetivo é permitir o cadastro de clientes, registrar suas movimentações de depósito e saque,
atualizar as contas de acordo com o tipo de conta e gravar os dados em um arquivo de saída.

## Funcionalidades

O projeto oferece as seguintes funcionalidades:

01. Cadastro de Clientes: Permite cadastrar clientes informando o nome e o tipo de conta (física, conjunta, jurídica ou especial). Gera um código de conta aleatório para cada cliente cadastrado.

02. Movimentações: Permite realizar movimentações financeiras (depósito e saque) para cada cliente cadastrado. O saldo atual e o limite de cada cliente são exibidos durante as movimentações.

03. Atualização de Contas: Atualiza o limite de cada conta de acordo com o tipo de conta. O limite é calculado com base no saldo atual e em um fator multiplicativo específico para cada tipo de conta.

04. Listagem de Clientes: Exibe os dados dos clientes cadastrados, incluindo nome, tipo de conta, código da conta, saldo em conta e limite atual.

05. Gravação de Dados: Permite gravar os dados dos clientes em um arquivo de saída. O usuário informa o nome do arquivo, e os dados são gravados em formato de texto, separados por linhas e com a extensão ".txt".

## Como Utilizar

01. Clone o repositório do projeto em sua máquina local:

```bash
git clone https://github.com/IWMVI/ContasCorrentes.git
```
02. Certifique-se de ter o Java JDK instalado em sua máquina.

03. Abra o projeto em sua IDE Java de preferência.

04. Compile e execute o arquivo principal Main.java para iniciar o programa.

05. Siga as instruções exibidas no console para interagir com as funcionalidades do programa.

## Requisitos

Java JDK (versão compatível com o projeto 17+)

## Bibliotecas e Tecnologias Utilizadas

- Linguagem de programação: Java
- IDE: Visual Studio Code
- Bibliotecas externas: Nenhuma

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias, correções de bugs ou novas funcionalidades.

## Autor

Wallace Martins
