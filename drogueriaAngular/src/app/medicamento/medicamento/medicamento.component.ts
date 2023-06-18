import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { MedicamentoService } from 'src/app/service/medicamento.service';
import { Medicamento } from 'src/model/Medicamento';
import { Venta } from 'src/model/Venta';

@Component({
  selector: 'app-medicamento',
  templateUrl: './medicamento.component.html',
  styleUrls: ['./medicamento.component.scss'],
  providers: [NgbModalConfig, NgbModal],
})
export class MedicamentoComponent implements OnInit {
  public gestionarMedicamentoForm : FormGroup;
  public gestionarVentaForm : FormGroup;
  public listaMedicamentos : Array<Medicamento>;
  public medicamento : Medicamento;
  public venta : Venta;

  constructor( private medicamentoService : MedicamentoService, private formBuilder : FormBuilder,
    private router : Router,config: NgbModalConfig, private modalService: NgbModal,){

    config.backdrop = 'static';
		config.keyboard = true;

    this.gestionarMedicamentoForm = this.formBuilder.group({
      nombre:[null, Validators.required],
      laboratorio : [null, Validators.required],
      cantidadStock : [null, Validators.required],
      valorUnitario : [null, Validators.required],
      fechaFabricacion: [null, Validators.required],
      fechaVencimiento: [null, Validators.required]
    
    });

    this.gestionarVentaForm = this.formBuilder.group({
      nombre:[null, Validators.required],
      cantidadComprar : [null, Validators.required]
    });

  

  }
  ngOnInit(): void {

    this.listaMedicamentos = new Array<Medicamento>();
    this.medicamento = new Medicamento();
    this.venta = new Venta;
    this.obtenerMedicamentos();
  }

  /**
  * @description metodo que obtiene la lista de todos los medicamentos
  */
  private obtenerMedicamentos() : void{
  console.log("incia metodo ObtenerMedicamentos()" );


  this.medicamentoService.obtenerMedicamentos().subscribe( (medicamento : any) => {
    if(medicamento.status ==="SUCCESS"){
      this.listaMedicamentos = medicamento.data;
      
      alert("si se obtiene la lista");
    }
    });
  }
    
    

  /**
  * @description metodo que permite ejecutar la logica de la creacion de un medicamento
  * 
  */
  public crearMedicamento() : void {
  

    //if(this.gestionarMedicamentoForm.invalid) {
     // return;
   // }
    this.medicamento = this.gestionarMedicamentoForm.value; 

    this.medicamentoService.crearMedicamento(this.medicamento).subscribe(result => {
      if(result.status === "SUCCESS") {
      this.listaMedicamentos.push(this.medicamento);
      // Metodo que permite limpiar los campos del formulario
     // this.limpiarFormulario();

     alert("Se creó el medicamento con exito");
      this.obtenerMedicamentos();
      }
    }
    //, error => {
     // console.log(error);
     // alert("no se pudo crear");
     //}
      );

    }
      

  public eliminarMedicamento(medicamento : Medicamento) : void {
    let idMedicamento : number;
    idMedicamento = medicamento.idMedicamento;
    this.medicamentoService.eliminarMedicamento(idMedicamento).subscribe(result => {
        if(result) {
    
      this.obtenerMedicamentos();
      }
   });
  }

  // Metodo que permite limpiar los campos del formulario
  private limpiarFormulario() : void {
    this.medicamento = new Medicamento();
    this.gestionarMedicamentoForm.reset();

  }


  //este metodo trae el controles y los errores 
  get f(){
    return this.gestionarMedicamentoForm.controls;
  }


  public confirmarEliminacion(medicamento : any) : void {

    if(confirm("Esta seguro de eliminar el medicamento?")) {
      console.log('Eliminar');
      this.eliminarMedicamento(medicamento);

      alert("El medicamento se elimino con exito");
    }

  }

  
  //metodo que redirige a otro modulo
  public irActualizar(medicamen : Medicamento) : void {
    this.router.navigate(['app-medicamento', medicamen]);
  }

  public actualizarMedicamento(medicament : Medicamento): void{

  }

  
 // public comprarMedicamento(venta : Venta, idMedicamento : number): void{
    public comprarMedicamento(): void{

  }


}
