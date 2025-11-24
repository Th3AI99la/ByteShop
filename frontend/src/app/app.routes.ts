import { Routes } from '@angular/router';
import { ProdutoListComponent } from './components/produto-list/produto-list.component';
import { ProdutoFormComponent } from './components/produto-form/produto-form.component';
import { ProdutoDetailComponent } from './components/produto-detail/produto-detail.component';

export const routes: Routes = [
  { path: 'produtos', component: ProdutoListComponent },
  { path: 'produtos/novo', component: ProdutoFormComponent },
  { path: 'produtos/editar/:id', component: ProdutoFormComponent },
  { path: 'produtos/detalhe/:id', component: ProdutoDetailComponent },
  { path: '', redirectTo: '/produtos', pathMatch: 'full' }
];
