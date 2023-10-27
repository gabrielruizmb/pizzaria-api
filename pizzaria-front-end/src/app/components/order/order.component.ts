import { Component, inject } from '@angular/core';
import { Flavour } from 'src/app/models/flavour';
import { Order } from 'src/app/models/order';
import { FlavourService } from 'src/app/services/flavour.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent {

  orderService = inject(OrderService);
  flavourService = inject(FlavourService);
  flavoursList: Flavour[] = [];
  order: Order = new Order();

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

  postOrder() {
    console.log(this.order);
    this.orderService.post(this.order).subscribe({
      next: response => {
        console.log(response);
        alert("Pedido feito com sucesso!");
      },
      error: response => {
        console.log(response);
        alert("Informações do pedido inválidas.");
      }
    })
  }
}
