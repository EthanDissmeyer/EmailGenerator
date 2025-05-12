import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Import CommonModule


@Component({
  selector: 'app-client-selector',
  standalone: true,
  imports: [CommonModule],
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

  // Placeholder function to handle client selection
  onClientSelect(event: Event): void {
    const selectedClientId = (event.target as HTMLSelectElement).value;
    console.log(`Selected client ID: ${selectedClientId}`);
    // TODO: Connect to the backend to fetch client-specific data
  }
}