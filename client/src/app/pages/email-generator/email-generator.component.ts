import { Component } from '@angular/core';
import { ClientSelectorComponent } from '../../components/client-selector/client-selector.component';
import { SelectTransactionComponent } from '../../components/select-transaction/select-transaction.component';
import { SelectTemplateComponent } from '../../components/select-template/select-template.component';

@Component({
  selector: 'app-email-generator',
  standalone: true,
  imports: [
    ClientSelectorComponent,
    SelectTransactionComponent,
    SelectTemplateComponent
  ],
  templateUrl: './email-generator.component.html',
  styleUrl: './email-generator.component.css'
})
export class EmailGeneratorComponent { }
