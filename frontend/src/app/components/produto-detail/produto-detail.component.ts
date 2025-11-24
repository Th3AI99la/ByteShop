import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router'; // RouterLink para o botão de voltar
import { Produto } from '../../models/produto.model';
import { ProdutoService } from '../../services/produto.service';
import { CommonModule } from '@angular/common'; // Importante para pipes de data, moeda e json

@Component({
  selector: 'app-produto-detail',
  standalone: true,
  imports: [CommonModule, RouterLink], // Importamos o que vamos usar no HTML
  templateUrl: './produto-detail.component.html',
  styleUrls: ['./produto-detail.component.css']
})
export class ProdutoDetailComponent implements OnInit {

  produto?: Produto; // Pode ser undefined enquanto carrega

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private produtoService: ProdutoService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.produtoService.consultarPorId(+id).subscribe({
        next: (dados) => this.produto = dados,
        error: (err) => console.error('Erro ao buscar produto', err)
      });
    }
  }

  voltar(): void {
    this.router.navigate(['/produtos']);
  }
}
