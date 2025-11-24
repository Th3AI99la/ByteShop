export interface Categoria {
  id?: number;
  nome: string;
}

export interface DetalheProduto {
  id?: number;
  especificacaoTecnica: string;
  garantiaMeses: number;
}

export interface Produto {
  id?: number;
  nome: string;
  preco: number;
  quantidadeEstoque: number;
  disponivel: boolean;
  dataCadastro: string;
  categoria?: Categoria; // Associação com Categoria OBS: o campo é opcional
  detalhe?: DetalheProduto;
}
