import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produto, Categoria } from '../../models/produto.model'; // Importamos Categoria
import { ProdutoService } from '../../services/produto.service';
import { CategoriaService } from '../../services/categoria.service'; // Importamos o Service novo

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-produto-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.css']
})
export class ProdutoFormComponent implements OnInit {

  // Inicializamos o produto já com o objeto 'detalhe' vazio para não dar erro no HTML
  produto: Produto = {
    nome: '',
    preco: 0,
    quantidadeEstoque: 0,
    disponivel: true,
    dataCadastro: new Date().toISOString().split('T')[0],
    detalhe: {
      especificacaoTecnica: '',
      garantiaMeses: 0
    },
    categoria: undefined // Começa sem categoria
  };

  categorias: Categoria[] = []; // Lista para preencher o <select>
  isEditMode = false;

  constructor(
    private produtoService: ProdutoService,
    private categoriaService: CategoriaService, // Injeção do service
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    // 1. Carregar as categorias para o dropdown
    this.carregarCategorias();

    // 2. Verificar se é edição
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.produtoService.consultarPorId(+id).subscribe(dados => {
        this.produto = dados;
        // Garantir que detalhe não seja nulo se vier do banco vazio
        if (!this.produto.detalhe) {
            this.produto.detalhe = { especificacaoTecnica: '', garantiaMeses: 0 };
        }
      });
    }
  }

  carregarCategorias(): void {
    this.categoriaService.listar().subscribe({
      next: (dados) => this.categorias = dados,
      error: (e) => console.error('Erro ao carregar categorias (crie o Controller Java!)', e)
    });
  }

  salvar(): void {
    // Ajuste: O Backend espera um objeto Categoria completo, mas o select as vezes manda só o ID.
    // O Angular com ngValue resolve isso se configurado certo.

    if (this.isEditMode && this.produto.id) {
      this.produtoService.alterar(this.produto.id, this.produto).subscribe(() => {
        this.router.navigate(['/produtos']);
      });
    } else {
      this.produtoService.incluir(this.produto).subscribe(() => {
        this.router.navigate(['/produtos']);
      });
    }
  }

  cancelar(): void {
    this.router.navigate(['/produtos']);
  }

  compararCategorias(c1: Categoria, c2: Categoria): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
