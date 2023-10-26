import { Component, inject } from '@angular/core';
import { Flavour } from 'src/app/models/flavour';
import { FlavourService } from 'src/app/services/flavour.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent {

  flavourService = inject(FlavourService);
  flavoursList: Flavour[] = [];

  constructor() {
    this.getAll();
  }

  getAll() {
    this.flavourService.getAll().subscribe({
      next: flavoursList => {
        this.flavoursList = flavoursList;
        console.log(this.flavoursList);
      },
      error: response => {
        console.log(response);
      }
    });
  }
}
