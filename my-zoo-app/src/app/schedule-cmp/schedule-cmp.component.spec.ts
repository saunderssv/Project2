import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleCmpComponent } from './schedule-cmp.component';

describe('ScheduleCmpComponent', () => {
  let component: ScheduleCmpComponent;
  let fixture: ComponentFixture<ScheduleCmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScheduleCmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleCmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
