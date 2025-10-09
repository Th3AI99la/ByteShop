import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component'; // ou o nome correto do seu componente principal

// Bootstrapping da aplicação Angular
bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
