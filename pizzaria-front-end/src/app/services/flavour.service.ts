import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Flavour } from '../models/flavour';

@Injectable({
  providedIn: 'root'
})
export class FlavourService {

  apiURL: string = 'http://localhost:8080/sabores';
  http = inject(HttpClient);

  constructor() { }

  getAll(): Observable<Flavour[]> {
    return this.http.get<Flavour[]>(this.apiURL);
  }
}
