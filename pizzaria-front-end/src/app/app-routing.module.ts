import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './components/layout/index/index.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { OrderComponent } from './components/order/order.component';
import { FlavourFormComponent } from './components/flavour-form/flavour-form.component';

const routes: Routes = [
  { path: "", component: IndexComponent, children: [
    { path: "pedido", component: OrderComponent },
    { path: "sabor/novo", component: FlavourFormComponent },
    { path: "sabor/:action/:id", component: FlavourFormComponent }
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
