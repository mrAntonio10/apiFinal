import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common'
import { FullCalendarComponent } from './full-calendar.component';
import { OffscreenFragmentComponent } from './utils/offscreen-fragment.component';
import { TransportContainerComponent } from './utils/transport-container.component';
import { LoginComponent } from './lib/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "../../app/src/app-routing.module";
import {RouterOutlet} from "@angular/router";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { CalendarioLocalComponent } from './lib/calendario-local/calendario-local.component';

@NgModule({
  declarations: [
    FullCalendarComponent,
    OffscreenFragmentComponent,
    TransportContainerComponent,
  ],
  imports: [
    CommonModule,
    //Copia de otro proyecto
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  exports: [
    FullCalendarComponent, LoginComponent
  ]
})
export class FullCalendarModule { }
