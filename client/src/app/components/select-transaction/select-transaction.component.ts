import { Component, HostListener, ElementRef, ViewChild, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TransactionTypeService } from '../../services/transaction-type.service';

@Component({
  selector: 'app-select-transaction',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './select-transaction.component.html',
  styleUrl: './select-transaction.component.css'
})
export class SelectTransactionComponent {
  @ViewChild('searchContainer') searchContainer!: ElementRef;
  searchTerm = '';
  isOpen = signal(false);

  transactionTypes = [
    'New Client',
    'Endorsement',
    'Quotes',
    'Proposal Reminder',
    'Renewal',
    'Confirmation Email'
  ];

  constructor(private txService: TransactionTypeService) {}

  get filteredTransactions() {
    const term = this.searchTerm.toLowerCase().trim();
    return term
      ? this.transactionTypes.filter(t => t.toLowerCase().includes(term))
      : this.transactionTypes;
  }

  openDropdown(): void {
    this.isOpen.set(true);
  }

  selectTransaction(type: string): void {
    this.searchTerm = type;
    this.txService.selectedType.set(type);
    this.isOpen.set(false);
  }

  @HostListener('document:click', ['$event'])
  onClickOutside(event: Event): void {
    if (!this.searchContainer.nativeElement.contains(event.target)) {
      this.isOpen.set(false);
    }
  }
}
