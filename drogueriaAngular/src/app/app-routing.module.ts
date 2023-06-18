import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MedicamentoComponent } from './medicamento/medicamento/medicamento.component';

const routes: Routes = [

  { 
  path: 'app-medicamento', 
  component:MedicamentoComponent
 }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
