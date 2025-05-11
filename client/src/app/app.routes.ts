import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { EmailGeneratorComponent } from './pages/email-generator/email-generator.component';
import { ClientSelectorComponent } from './components/client-selector/client-selector.component';


export const routes: Routes = [
    {
        path: '',
        component: HomeComponent, 
        title: 'Home',
    },
    {
        path: 'email-generator',
        component: EmailGeneratorComponent,
        title: 'Email Generator',
    }

];
