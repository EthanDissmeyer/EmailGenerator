import { Component, ElementRef, ViewChild, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { SelectTemplateService } from '../../services/select-template.service';

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

  constructor(private templateService: SelectTemplateService) {}

  ngOnInit() {
    this.templateService.getTemplates().subscribe((data: any[]) => {
      this.templates = data;
    });
  }

  get filteredTemplates() {
    const term = this.searchTerm.toLowerCase().trim();
    if (!term) return this.templates;
    return this.templates.filter(template =>
      template.name.toLowerCase().includes(term)
    );
  }

  openDropdown(): void {
    this.isOpen.set(true);
  }

  selectTemplate(template: any): void {
    this.selectedTemplate = template;
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
}
