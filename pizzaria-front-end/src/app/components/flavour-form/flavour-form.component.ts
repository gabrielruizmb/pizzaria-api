import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Flavour } from 'src/app/models/flavour';
import { FlavourService } from 'src/app/services/flavour.service';

@Component({
  selector: 'app-flavour-form',
  templateUrl: './flavour-form.component.html',
  styleUrls: ['./flavour-form.component.scss']
})
export class FlavourFormComponent {

  route = inject(ActivatedRoute);
  flavourService = inject(FlavourService);
  formAction!: string;
  flavour: Flavour = new Flavour();
  id!: string;

  constructor() {
    let id = this.route.snapshot.paramMap.get('id');
    let action = this.route.snapshot.paramMap.get('action');
    action === null ? this.formAction = 'cadastrar' : this.formAction = action;

    if(id !== null) {
      this.id = id;
      this.getOne(id);
    }

    console.log(id);
    console.log(this.formAction);
  }

  onSubmit() {
    console.log(this.flavour);
    if(this.formAction === 'cadastrar') { this.post(this.flavour) };
    if(this.formAction === 'editar') { this.put(this.id, this.flavour) };
    if(this.formAction === 'excluir') { this.delete(this.id) };
  }

  getOne(id: any) {
    this.flavourService.getOne(id).subscribe({
      next: flavour => {
        this.flavour = flavour;
      },
      error: response => {
        console.log(response);
        alert("Sabor não encontrado.")
      }
    });
  }

  post(flavour: Flavour) {
    this.flavourService.post(flavour).subscribe({
      next: response => {
        this.flavour = new Flavour();
        console.log(response);
        alert("Sabor cadastrado com sucesso!");
      },
      error: response => {
        console.log(response);
        alert("Informações inválidas, não foi possível cadastrar o sabor.");
      }
    });
  }

  put(id: any, flavour: Flavour) {
    this.flavourService.put(id, flavour).subscribe({
      next: response => {
        console.log(response);
        alert("Sabor editado com sucesso!");
      },
      error: response => {
        console.log(response);
        alert("Informações inválidas, não foi possível editar o sabor.")
      }
    });
  }

  delete(id: any) {
    this.flavourService.delete(id).subscribe({
      next: response => {
        console.log(response);
        alert("Sabor excluído com sucesso!");
      },
      error: response => {
        console.log(response);
        alert("Sabor não encontrado.");
      }
    });
  }
}
