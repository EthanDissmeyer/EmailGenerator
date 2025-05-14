// client-selector.component.ts
import { Component, inject, signal } from '@angular/core';
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
    console.log('Clients loaded:', data);  
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

  toggleOpen(): void {
    this.isOpen.update(v => !v);
  }

  selectClient(client: any): void {
    this.selectedClient.set(client);
    this.isOpen.set(false);
  }

  trackByClientId(_i: number, client: any): number {
    return client.id;
  }
}
