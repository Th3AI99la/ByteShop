// Esta interface garante que nossos objetos 'Produto' no frontend

export interface Produto {
  id?: number; // O id é opcional, pois pode ser gerado pelo backend
  nome: string;
  preco: number;
  quantidadeEstoque: number;
  disponivel: boolean;
  dataCadastro: string;
}
