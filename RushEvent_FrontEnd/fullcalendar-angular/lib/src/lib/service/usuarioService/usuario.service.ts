import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Usuario, UsuarioI} from "../../model/usuario/usuario";

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private baseUrl = "http://localhost:8084/api/usuarios";

  constructor(private httpClient: HttpClient) {
  }

  getUserList(): Observable<Usuario[]>{
      return this.httpClient.get<Usuario[]>(`${this.baseUrl}/findAllUsers`)
  }
//ejemplo de post
//   updateArduino(arduino: ArduinoI): Observable<ArduinoI> {
//     return this.httpClient.post<ArduinoI>(`${this.baseUrl}`, arduino);
//   }

  logInUsuario (usuario: UsuarioI): Observable<UsuarioI> {
    return this.httpClient.post<UsuarioI>(`${this.baseUrl}/logIn`,  usuario);
  }
}
