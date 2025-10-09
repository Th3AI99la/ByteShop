import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produto } from '../../models/produto.model';
import { ProdutoService } from '../../services/produto.service';

// Importações necessárias
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-produto-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.css']
})
export class ProdutoFormComponent implements OnInit {
  produto: Produto = {
    nome: '',
    preco: 0,
    quantidadeEstoque: 0,
    disponivel: true,
    dataCadastro: new Date().toISOString().split('T')[0]
  };

  isEditMode = false;

  constructor(
    private produtoService: ProdutoService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.produtoService.consultarPorId(+id).subscribe(dados => {
        this.produto = dados;
      });
    }
  }

  salvar(): void {
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
}
