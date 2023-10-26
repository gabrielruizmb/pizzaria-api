import { Component } from '@angular/core';
import { Flavour } from 'src/app/models/flavour';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent {

  flavoursList: Flavour[] = [];
}
