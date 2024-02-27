Feature: Montar carrinho de compras
  Scenario: Usuario deseja montar o carrinho com 2 produtos
    Given o usuario tenha acessado a pagina inicial do site Giuliana Flores
    When ele pesquisa por "Orquídea Mine Rara Rosa"
    And adiciona o produto ao carrinho
    And depois por "Buquê Magnificas Margaridas Amarelas"
    And realiza o mesmo processo
    Then ele consegue adicionar ambos os itens ao carrinho de forma separada
