import { Component, HostListener, ElementRef, ViewChild } from '@angular/core';
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
  dropdownOpen = false;

  // transaction types can be confirmed later with client
  // also maybe put these into the database
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

  get showDropdown(): boolean {
    return this.dropdownOpen;
  }

  // to use transaction type in another component (probably for templates):
  // this.variablename = sessionStorage.getItem('selectedTransaction');
  selectTransaction(type: string): void {
    this.dropdownOpen = false;
    this.searchTerm = type;
    sessionStorage.setItem('selectedTransaction', type);
  }

  onInputFocus(): void {
    this.dropdownOpen = true;
  }

  onInputChange(): void {
    this.dropdownOpen = this.searchTerm.trim().length > 0;
  }

  @HostListener('document:click', ['$event'])
  onClickOutside(event: Event) {
    if (!this.searchContainer.nativeElement.contains(event.target)) {
      this.dropdownOpen = false;
    }
  }
}
