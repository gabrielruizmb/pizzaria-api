import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  apiURL: string = 'http://localhost:8080/pedidos';
  http = inject(HttpClient);

  constructor() { }

  post(order: Order): Observable<string> {
    return this.http.post<string>(this.apiURL, order);
  }
}
