import { Component, ElementRef, HostListener, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientService } from '../../services/client.service';

@Component({
  selector: 'app-client-selector',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './client-selector.component.html',
  styleUrl: './client-selector.component.css'
})
export class ClientSelectorComponent {
  private clientService = inject(ClientService);
  private hostElement = inject(ElementRef);

  clients = signal<any[]>([]);
  isOpen = signal(false);
  selectedClient = signal<any | null>(null);
  isSearching = signal(false);
  searchQuery = signal('');

  constructor() {
    this.loadClients();
  }

  private loadClients(): void {
    this.clientService.getAllClients().subscribe(data => {
      this.clients.set(data as any[]);
    });
  }

  searchClients(query: string): void {
    this.searchQuery.set(query);

    if (!query.trim()) {
      this.isSearching.set(false);
      this.loadClients();
      return;
    }

    this.isSearching.set(true);
    this.clientService.getClientBySearch(query)
      .subscribe(data => this.clients.set(data as any[]));
  }

  openDropdown(): void {
    this.isOpen.set(true);
  }

  selectClient(client: any): void {
    const displayName = client.name || `${client.firstName} ${client.lastName}`;
    this.searchQuery.set(`${displayName} ${client.contactRef}`);
    this.selectedClient.set(client);
    this.isOpen.set(false);
  }

  trackByClientId(_i: number, client: any): number {
    return client.id;
  }

  @HostListener('document:click', ['$event'])
  handleOutsideClick(event: MouseEvent) {
    if (!this.hostElement.nativeElement.contains(event.target)) {
      this.isOpen.set(false);
    }
  }
}
