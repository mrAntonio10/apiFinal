import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Evento, EventoI} from "../../model/evento/evento";

@Injectable({
  providedIn: 'root'
})
export class EventoService {
  private baseUrl = "http://localhost:8084/api/eventos";

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Evento[]>{
    return this.httpClient.get<Evento[]>(`${this.baseUrl}`)
  }

  getEventoById(id: number): Observable<Evento[]>{
    return this.httpClient.get<Evento[]>(`${this.baseUrl}/`+id)
  }

  postEventoById(parametro: EventoI): Observable<Evento[]> {
    return this.httpClient.post<Evento[]>(`${this.baseUrl}`, parametro);
  }
}
