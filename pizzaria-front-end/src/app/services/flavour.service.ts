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

  getOne(id: number): Observable<Flavour> {
    return this.http.get<Flavour>(this.apiURL + '/' + id);
  }

  post(flavour: Flavour): Observable<string> {
    return this.http.post<string>(this.apiURL, flavour);
  }

  put(id: number, flavour: Flavour): Observable<string> {
    return this.http.put<string>(this.apiURL + '/' + id, flavour);
  }

  delete(id: number): Observable<string> {
    return this.http.delete<string>(this.apiURL + '/' + id);
  }
}
