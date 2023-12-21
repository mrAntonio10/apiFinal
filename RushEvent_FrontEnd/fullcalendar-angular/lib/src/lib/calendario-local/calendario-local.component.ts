import {Component, forwardRef, OnInit, ViewChild} from '@angular/core';
import {Calendar, CalendarOptions, EventClickArg} from "@fullcalendar/core";
import {FullCalendarComponent} from "@fullcalendar/angular";
import dayGridPlugin from "@fullcalendar/daygrid";
import interactionPlugin, {DateClickArg, EventDragStopArg} from "@fullcalendar/interaction";
import {EventoService} from "../service/eventoService/evento.service";

@Component({
  selector: 'lib-calendario-local',
  templateUrl: './calendario-local.component.html',
  styleUrls: ['./calendario-local.component.css']
})
export class CalendarioLocalComponent implements OnInit {

  calendarOptions?: CalendarOptions;
  eventsModel: any;
  @ViewChild('fullcalendar') fullcalendar?: FullCalendarComponent;

  ngOnInit() {
    /*
    PARTE PRUEBA
    */
    console.log("HOLA", );

    // need for load calendar bundle first
    forwardRef(() => Calendar);

    this.calendarOptions = {
      plugins: [dayGridPlugin, interactionPlugin],
      editable: true,
      customButtons: {
        myCustomButton: {
          text: 'custom!',
          click: function () {
            alert('clicked the custom button!');
          }
        }
      },
      headerToolbar: {
        left: 'prev,next today myCustomButton',
        center: 'title',
        right: 'dayGridMonth'
      },
      dateClick: this.handleDateClick.bind(this),
      eventClick: this.handleEventClick.bind(this),
      eventDragStop: this.handleEventDragStop.bind(this)
    };
  }

  handleDateClick(arg: DateClickArg) {
    console.log(arg);
  }

  handleEventClick(arg: EventClickArg) {
    console.log(arg);
  }

  handleEventDragStop(arg: EventDragStopArg) {
    console.log(arg);
  }

  updateHeader() {
    this.calendarOptions!.headerToolbar = {
      left: 'prev,next myCustomButton',
      center: 'title',
      right: ''
    };
  }

  constructor(private eventoService: EventoService) {
  }
  updateEvents() {
    const nowDate = new Date();
    const yearMonth = nowDate.getUTCFullYear() + '-' + (nowDate.getUTCMonth() + 1);

    this.eventoService.getAll().subscribe(data => {
      console.log(data);
      // data.forEach( evento => {
      //   this.calendarOptions!.events = [{
      //     title: evento.nombreEvento,
      //     start: evento.fechaEvento,
      //     end: evento.fechaFinEvento
      //   }]
      // })
    },  err => {
      console.log(err);
      alert("Usuario no valido en sistema");
    })

    console.log(yearMonth)

    this.calendarOptions!.events = [{
      title: 'Evento Coca Cola Fest',
      start: yearMonth + '-08',
      end: yearMonth + '-10'
    }];
  }

}
