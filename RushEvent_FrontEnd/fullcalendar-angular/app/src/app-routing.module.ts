import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule} from "@angular/router";
import {AppComponent} from "./app.component";
import {LoginComponent} from "../../lib/src/lib/login/login.component";
import {CalendarioLocalComponent} from "../../lib/src/lib/calendario-local/calendario-local.component";


//Rutas de navegacion
const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'calendar', component: CalendarioLocalComponent},
  // { path: 'registro', component: RegistroComponent},   COMPONENTE PRINCIPAL
]
@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ]
})
export class AppRoutingModule { }
