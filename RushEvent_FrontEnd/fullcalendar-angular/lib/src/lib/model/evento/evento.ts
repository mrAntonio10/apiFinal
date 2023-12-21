import {Usuario} from "../usuario/usuario";

export class Evento {

  id: number = 0;
  nombreEvento: string = '';
  description: string = '';
  fechaEvento: string = '';
  fechaFinEvento: string = '';
  horaEvento: string = '';
  estadoEvento: boolean = false;
  username: string = '';
  nombreCompleto: string = '';

}

export interface EventoI {

  id: number;
  nombreEvento: string;
  description: string;
  fechaEvento: string;
  fechaFinEvento: string;
  horaEvento: string;
  estadoEvento: boolean;
  usuario: Usuario;

}


