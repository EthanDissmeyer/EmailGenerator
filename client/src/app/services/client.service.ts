import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ClientService {

  private http = inject(HttpClient);
  private baseUrl = environment.apiBaseUrl;

  getAllClients() {
    return this.http.get(`${this.baseUrl}/clients`);
  }

  getClientBySearch(search: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/clients/search`, {
      params: {query: search}
    });
  }
}
