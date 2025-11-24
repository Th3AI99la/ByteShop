import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categoria } from '../models/produto.model';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  private apiUrl = 'http://localhost:8080/api/categorias'; // URL base para categorias

  constructor(private http: HttpClient) { }

  listar(): Observable<Categoria[]> {
    // Retorna um Observable com a lista de todas as categorias.
    return this.http.get<Categoria[]>(this.apiUrl);
  }
}
