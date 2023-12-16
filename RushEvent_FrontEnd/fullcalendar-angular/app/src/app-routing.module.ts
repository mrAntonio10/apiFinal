import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule} from "@angular/router";


//Rutas de navegacion
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  // { path: 'home', component: LogInComponent},    COMPONENTE LOGIN
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
