import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FullCalendarModule } from '@fullcalendar/angular';
import { AppComponent } from './app.component';
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {RouterModule, RouterOutlet} from "@angular/router";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {LoginComponent} from "../../lib/src/lib/login/login.component";
import {CalendarioLocalComponent} from "../../lib/src/lib/calendario-local/calendario-local.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CalendarioLocalComponent,

  ],
  imports: [
    BrowserModule,
    FullCalendarModule,
    //Copia de otro proyecto
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    // RouterOutlet, REVISAR NPM
    ReactiveFormsModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
