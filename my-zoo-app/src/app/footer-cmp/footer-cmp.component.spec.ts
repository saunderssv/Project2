import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { Router } from '@angular/router';
import { FooterCmpComponent } from './footer-cmp.component';


const routerSpy = jasmine.createSpyObj('Router', ['navigate']);

describe('FooterCmpComponent', () => {
  let component: FooterCmpComponent;
  let fixture: ComponentFixture<FooterCmpComponent>;
  let router: Router;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FooterCmpComponent ],
      providers: [
        { provide: Router, useValue: routerSpy }
      ]
      
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterCmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // it(`should tell ROUTER to navigate when Administration is clicked`, ()=>{
    
  //   component.onClickLogin(event);
    
  //     // args passed to router.navigateByUrl() spy
  //     const spy = component.router.navigate as jasmine.Spy;
  //     const navArgs = spy.calls.first().args[0];
    
  //     // expecting to navigate to the login page
  //     expect(navArgs).toBe('/app-login-cmp',
  //       'should nav to the Login page');
  //   });
  
});
