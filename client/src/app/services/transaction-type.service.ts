import { Injectable, signal } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class TransactionTypeService {
  //current selected txn type 
  selectedType = signal<string>('');
}
