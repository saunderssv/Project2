import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AgmCoreModule } from '@agm/core';
import { AgmSnazzyInfoWindowModule } from '@agm/snazzy-info-window';


import { AppComponent } from './app.component';
import { CounterComponent } from './counter/counter.component';
import { MapCmpComponent } from './map-cmp/map-cmp.component';
import { SupportCmpComponent } from './support-cmp/support-cmp.component';
import { ScheduleCmpComponent } from './schedule-cmp/schedule-cmp.component';
import { HomeCmpComponent } from './home-cmp/home-cmp.component';
import { LoginCmpComponent } from './login-cmp/login-cmp.component';
import { LoginService } from './services/login.service';
import { AdministratorCmpComponent } from './administrator-cmp/administrator-cmp.component';

export const appRoutes: Routes = [
  {path: 'app-administrator-cmp', component: AdministratorCmpComponent},
  {path: 'app-login-cmp', component: LoginCmpComponent},
  {path: 'app-home-cmp', component: HomeCmpComponent },
  {path: 'app-schedule-cmp', component: ScheduleCmpComponent },
  {path: 'app-map-cmp', component: MapCmpComponent },
  {path: 'app-support-cmp', component: SupportCmpComponent }
]


@NgModule({
  declarations: [
    AppComponent,
    CounterComponent,
    MapCmpComponent,
    SupportCmpComponent,
    ScheduleCmpComponent,
    HomeCmpComponent,
    LoginCmpComponent,
    AdministratorCmpComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCzmUXpFk8e2YyzNvUzz0PJ12T5bCkKO7s'
    }),
    AgmSnazzyInfoWindowModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
