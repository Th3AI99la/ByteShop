import { Component, OnInit } from '@angular/core';
import { Produto } from '../../models/produto.model';
import { ProdutoService } from '../../services/produto.service';

// Importações necessárias para um componente standalone
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-produto-list',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink
  ],
  templateUrl: './produto-list.component.html',
  styleUrls: ['./produto-list.component.css']
})
export class ProdutoListComponent implements OnInit {
  produtos: Produto[] = [];

  constructor(private produtoService: ProdutoService) { }

  ngOnInit(): void {
    this.carregarProdutos();
  }

  carregarProdutos(): void {
    this.produtoService.listar().subscribe(dados => {
      this.produtos = dados;
    });
  }

  excluir(id: number | undefined): void {
    if (id) {
      if (confirm("Tem certeza que deseja excluir este produto?")) {
        this.produtoService.excluir(id).subscribe(() => {
          this.carregarProdutos();
        });
      }
    }
  }
}
