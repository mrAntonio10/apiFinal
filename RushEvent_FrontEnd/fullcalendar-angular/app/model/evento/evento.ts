import {Usuario} from "../usuario/usuario";

export class Evento {

  id: number = 0;
  nombreEvento: string = '';
  description: string = '';
  fechaEvento: string = '';
  fechaFinEvento: string = '';
  horaEvento: string = '';
  estadoEvento: boolean = false;
  // @ts-ignore
  usuario: Usuario;

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


