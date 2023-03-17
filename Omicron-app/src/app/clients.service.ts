import { Injectable } from '@angular/core';
import { Client } from './clients/client';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private http: HttpClient) {

  }

  postClient(client: Client): Observable<Client> {
    return this.http.post<Client>("http://localhost:8080/api/clients", client)
  }

  getClient(): Client {
    let client: Client = new Client();
    return client;
  }
}