import { Component, signal } from '@angular/core';


@Component({
  selector: 'app-client-selector',
  standalone: true,
  imports: [],
  templateUrl: './client-selector.component.html',
  styleUrl: './client-selector.component.css'
})
export class ClientSelectorComponent {
  // Mock data for clients
  clients = [
    { id: 1, name: 'Client A' },
    { id: 2, name: 'Client B' },
    { id: 3, name: 'Client C' }
  ];

  // Signal for dropdown open state
  isOpen = signal(false);

  // Signal for selected client
  selectedClient = signal<{ id: number; name: string } | null>(null);

  // Toggle dropdown open state
  toggleOpen(): void {
    this.isOpen.set(!this.isOpen());
  }

  // Select a client
  selectClient(client: { id: number; name: string }): void {
    this.selectedClient.set(client);
    this.isOpen.set(false);
    console.log(`Selected client: ${client.name}`);
  }

  // TrackBy function for clients
  trackByClientId(index: number, client: { id: number; name: string }): number {
    return client.id;
  }
}