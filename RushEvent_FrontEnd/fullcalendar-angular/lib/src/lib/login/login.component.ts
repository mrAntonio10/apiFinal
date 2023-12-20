import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {UsuarioService} from "../service/usuarioService/usuario.service";

@Component({
  selector: 'lib-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
// @ts-ignore
  form: FormGroup;

  constructor(private router: Router,
              private usuarioService: UsuarioService) {
  }
  ngOnInit() {

    // @ts-ignore
    this.form = new FormGroup({
      nombreUsuario:new FormControl('', [Validators.required]),
      password:new FormControl('', [Validators.required]),
    });
  }
  navegar() {
    this.router.navigate(['/menu-principal'])
  }

  submitForm(){
    console.log(this.form.value)
    this.usuarioService.logInUsuario(this.form.value).subscribe(data => {
      console.log(data);
      if(data){
        this.router.navigate(['/calendar']);
      }
    },  err => {
      console.log(err);
      alert("Usuario no valido en sistema");
    })
  }

}




