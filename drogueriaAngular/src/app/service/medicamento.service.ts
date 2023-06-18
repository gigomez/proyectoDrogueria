import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medicamento } from 'src/model/Medicamento';

const back_end_url = "http://localhost:8080/"

@Injectable({
  providedIn: 'root'
})
export class MedicamentoService {

  constructor(private httpClient : HttpClient) { }

  public obtenerMedicamentos() : Observable<any> {
    return this.httpClient.get(back_end_url + 'drogueria/obtenerMedicamentos');

  }

  public crearMedicamento(medicamento : Medicamento) : Observable<any> {
   
    return this.httpClient.post<any>(back_end_url + 'drogueria/crearMedicamento', medicamento);
  }

  public actualizarMedicamento(medicamento : Medicamento) : Observable<any> {
    //RequestBody POST PUT
    return this.httpClient.put<any>(back_end_url + 'drogueria/actualizarMedicamento', medicamento);
  }


  public eliminarMedicamento(idMedicamento: number) : Observable<Medicamento> {
    return this.httpClient.delete<Medicamento>(back_end_url + 'drogueria/eliminarMedicamento/'+ idMedicamento);
  }

}
