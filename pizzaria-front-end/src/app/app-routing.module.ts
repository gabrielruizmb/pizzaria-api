import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './components/layout/index/index.component';
import { MenuComponent } from './components/menu/menu.component';

const routes: Routes = [
  { path: "", component: IndexComponent , children: [
    { path: "menu", component: MenuComponent }
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
