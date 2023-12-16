export class Evento {

  id: number = 0;
  nombre: string = "";
  sensor_actuador: string = "";
  estado: boolean = false;
  parametroMax: number = 0;
  parametroMin: number = 0;

}

export interface EventoI {

  id: number;
  parametro: number;
  parametroMin: number;

}
