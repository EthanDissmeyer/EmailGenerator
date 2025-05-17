import { Component } from '@angular/core';
import { ClientSelectorComponent } from '../../components/client-selector/client-selector.component';
import { SelectTransactionComponent } from '../../components/select-transaction/select-transaction.component'; // Adjust the path if needed

@Component({
  selector: 'app-email-generator',
  standalone: true,
  imports: [
    ClientSelectorComponent,
    SelectTransactionComponent
  ],
  templateUrl: './email-generator.component.html',
  styleUrl: './email-generator.component.css'
})
export class EmailGeneratorComponent { }
