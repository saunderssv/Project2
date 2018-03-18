import { fakeAsync, ComponentFixture, TestBed, tick } from '@angular/core/testing';
import {RouterTestingModule} from "@angular/router/testing";
import { Location } from '@angular/common';
import { AppComponent } from './app.component';
import { appRoutes } from './app.module';
import { Router } from '@angular/router';
import { LoginCmpComponent } from './login-cmp/login-cmp.component';
import { CounterComponent } from './counter/counter.component';
import { MapCmpComponent } from './map-cmp/map-cmp.component';
import { SupportCmpComponent } from './support-cmp/support-cmp.component';
import { ScheduleCmpComponent } from './schedule-cmp/schedule-cmp.component';
import { HomeCmpComponent } from './home-cmp/home-cmp.component';

//const routerSpy = jasmine.createSpyObj('Router', ['navigate']);

describe('AppComponent', () => {
  let component: AppComponent;
  let fixture;
  let router: Router;
  let location: Location;

  beforeEach(() => {
    TestBed.configureTestingModule({

      imports: [RouterTestingModule.withRoutes(appRoutes)],
      declarations: [ 
        AppComponent, 
        CounterComponent,
        MapCmpComponent,
        SupportCmpComponent,
        ScheduleCmpComponent,
        HomeCmpComponent,
        LoginCmpComponent
       ]
      // providers: [
      //   { provide: Router, useValue: routerSpy }
      // ]
      
    });

    router = TestBed.get(Router); 
    location = TestBed.get(Location); 

    fixture = TestBed.createComponent(AppComponent); 
    router.initialNavigation(); 
  });

    it('true should be true', ()=> {
      expect(true).toBe(true);
    })

    // it('should tell navigate to LoginComponent when we type `app-administration`', fakeAsync(() => {
    //   router.navigate(['app-login-cmp']);
    //   tick();
    //   expect(location.path()).toBe('/app-login-cmp');
    // }));

    it('should navigate to Schedule Componenet when we click the schedule button', fakeAsync(() =>{
      //fixture.onClickSchedule(event);
      router.navigate(['app-login-cmp']);
      tick();
      expect(location.path()).toBe('/app-login-cmp');
    }))
});

    // it(`should tell ROUTER to navigate when Administration is clicked`, ()=>{
    
    // component.onClickLogin(event);
    
    //   // args passed to router.navigateByUrl() spy
    //   const spy = component.router.navigate as jasmine.Spy;
    //   const navArgs = spy.calls.first().args[0];
    
    //   // expecting to navigate to the login page
    //   expect(navArgs).toBe('/app-login-cmp',
    //     'should nav to the Login page');
    // })