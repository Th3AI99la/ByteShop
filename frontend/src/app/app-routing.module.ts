import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoListComponent } from './components/produto-list/produto-list.component';
import { ProdutoFormComponent } from './components/produto-form/produto-form.component';

const routes: Routes = [
  // Rota para a lista de produtos
  { path: 'produtos', component: ProdutoListComponent },

  // Rota para o formulário de criação de um novo produto
  { path: 'produtos/novo', component: ProdutoFormComponent },

  // Rota para o formulário de edição de um produto existente
  { path: 'produtos/editar/:id', component: ProdutoFormComponent },

  // Redireciona a rota raiz para a lista de produtos
  { path: '', redirectTo: '/produtos', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
