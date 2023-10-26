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

  constructor() {
    let id = this.route.snapshot.paramMap.get('id');
    let action = this.route.snapshot.paramMap.get('action');
    action === null ? this.formAction = 'cadastrar' : this.formAction = action;

    console.log(id);
    console.log(this.formAction);
  }

  onSubmit() {
    console.log(this.flavour);
    if(this.formAction === 'cadastrar') { this.post(this.flavour) };
  }

  post(flavour: Flavour) {
    this.flavourService.post(flavour).subscribe({
      next: response => {
        console.log(response);
        alert("Sabor cadastrado com sucesso!");
      },
      error: response => {
        console.log(response);
        alert("Informações inválidas, não foi possível cadastrar.");
      }
    });
  }
}
