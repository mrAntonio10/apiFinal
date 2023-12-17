export class Usuario {

  id: number = 0;
  nombreUsuario: string = '';
  password: string = '';
  nombreCompleto: string = '';
  estado: boolean = false;
}

export interface UsuarioI {
  id: number;
  nombreUsuario: string;
  password: string;
  nombreCompleto: string;
  estado: boolean;
}

export interface LoginI {
  nombre: string;
  password: string;
}

