import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarioLocalComponent } from './calendario-local.component';

describe('CalendarioLocalComponent', () => {
  let component: CalendarioLocalComponent;
  let fixture: ComponentFixture<CalendarioLocalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalendarioLocalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CalendarioLocalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
