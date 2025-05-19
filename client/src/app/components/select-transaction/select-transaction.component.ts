import { Component, HostListener, ElementRef, ViewChild, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-select-transaction',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './select-transaction.component.html',
  styleUrl: './select-transaction.component.css'
})
export class SelectTransactionComponent {
  searchTerm = '';
  isOpen = signal(false);

  transactionTypes = [
    'New Customer',
    'Renewal',
    'Cancellations',
    'Premiums',
    'Policy Changes',
    'Claims',
    'Commissions',
    'Quotes',
    'Invoices'
  ];

  @ViewChild('searchContainer') searchContainer!: ElementRef;

  get filteredTransactions() {
    const term = this.searchTerm.toLowerCase().trim();
    if (!term) return this.transactionTypes;
    return this.transactionTypes.filter(type =>
      type.toLowerCase().includes(term)
    );
  }

  openDropdown(): void {
    this.isOpen.set(true);
  }

  selectTransaction(type: string): void {
    this.isOpen.set(false);
    this.searchTerm = type;
    sessionStorage.setItem('selectedTransaction', type);
  }

  @HostListener('document:click', ['$event'])
  onClickOutside(event: Event) {
    if (!this.searchContainer.nativeElement.contains(event.target)) {
      this.isOpen.set(false);
    }
  }
}
