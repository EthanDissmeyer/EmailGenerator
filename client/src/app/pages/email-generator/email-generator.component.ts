import { Component } from '@angular/core';
import { ClientSelectorComponent } from '../../components/client-selector/client-selector.component';

@Component({
  selector: 'app-email-generator',
  standalone: true,
  imports: [ClientSelectorComponent],
  templateUrl: './email-generator.component.html',
  styleUrl: './email-generator.component.css'
})
export class EmailGeneratorComponent {

}
