Sistema de gerenciamento de vendas para um supermercado. 
Implementado as seguintes entidades e funcionalidades utilizando Spring Boot e Spring Data JPA.

Criação das entidades
Produto
id (Long) → Identificador único do produto.
descricao (String) → Descrição detalhada do produto.
preco (Double) → Preço unitário do produto.
setor (String) → Categoria do produto (exemplo: "Bebidas", "Laticínios", "Higiene").
validade (LocalDate) → Data de validade do produto.
Cliente
id (Long) → Identificador único do cliente.
cpf (String) → CPF do cliente (único).
celular (String) → Número de celular do cliente.
Venda
id (Long) → Identificador único da venda.
clienteId (Long) → Identificador do cliente que realizou a compra.
produtoId (Long) → Identificador do produto vendido.
descricaoProduto (String) → Descrição do produto vendido.
quantidade (Integer) → Quantidade de unidades compradas do produto.
precoProduto (Double) → Preço unitário do produto no momento da venda.
valorTotal (Double) → Valor total da venda (quantidade × precoProduto).
dataVenda (LocalDateTime) → Data e hora da venda
