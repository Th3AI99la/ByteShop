import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';

// Configuração do componente como standalone

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'byteshop-frontend';
}
