import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Produto } from '../models/produto.model';

// Este serviço é responsável por todas as operações relacionadas a produtos,
@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  // A URL base da nossa API backend.
  private apiUrl = 'http://localhost:8080/api/produtos';

  // Injeção do HttpClient para fazer requisições HTTP.
  constructor(private http: HttpClient) { }

  // LISTAR: Retorna um Observable com a lista de todos os produtos.
  listar(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.apiUrl);
  }

  // CONSULTAR: Busca um único produto pelo seu ID.
  consultarPorId(id: number): Observable<Produto> {
    const url = `${this.apiUrl}/${id}`; // URL dinâmica com o ID
    return this.http.get<Produto>(url);
  }

  // INCLUIR: Envia um novo produto para a API.
  incluir(produto: Produto): Observable<Produto> {
    return this.http.post<Produto>(this.apiUrl, produto);
  }

  // ALTERAR: Envia um produto atualizado para a API.
  alterar(id: number, produto: Produto): Observable<Produto> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.put<Produto>(url, produto);
  }

  // EXCLUIR: Solicita a exclusão de um produto pelo seu ID.
  excluir(id: number): Observable<any> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete(url);
  }
}
