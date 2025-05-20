import {Component, ElementRef, ViewChild, signal, effect, inject, HostListener} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SelectTemplateService } from '../../services/select-template.service';
import { TransactionTypeService } from '../../services/transaction-type.service';

@Component({
  selector: 'app-select-template',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './select-template.component.html',
  styleUrl: './select-template.component.css'
})
export class SelectTemplateComponent {
  @ViewChild('searchContainer') searchContainer!: ElementRef;

  searchTerm = '';
  isOpen = signal(false);
  templates: any[] = [];
  selectedTemplate: any = null;

  private templateService = inject(SelectTemplateService);
  private txService = inject(TransactionTypeService);

  constructor() {
    // gets the templates when txn type changes or on load
    effect(() => {
      const type = this.txService.selectedType();
      console.log('Selected transaction type:', type);

      const fetch$ = type
        ? this.templateService.getTemplatesByTransactionType(type)
        : this.templateService.getTemplates();

      fetch$.subscribe((data: any[]) => {
        console.log('Fetched templates:', data);
        this.templates = data;
        this.searchTerm = ''; 
        this.selectedTemplate = null; 
      });
    });
  }

  get filteredTemplates(): any[] {
    const term = this.searchTerm.toLowerCase().trim();
    return term
      ? this.templates.filter(t => t.name.toLowerCase().includes(term))
      : this.templates;
  }

  openDropdown(): void {
    this.isOpen.set(true);
  }

  selectTemplate(template: any): void {
    this.selectedTemplate = template;
    this.searchTerm = template.name; 
    this.isOpen.set(false);
  }

  closeModal(): void {
    this.selectedTemplate = null;
  }

  stopPropagation(event: Event): void {
    event.stopPropagation();
  }

  showModal(): boolean {
    return !!this.selectedTemplate;
  }

  @HostListener('document:click', ['$event'])
  onClickOutside(event: Event): void {
    if (!this.searchContainer.nativeElement.contains(event.target)) {
      this.isOpen.set(false);
    }
  }
}
