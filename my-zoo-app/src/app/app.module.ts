import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { CounterComponent } from './counter/counter.component';
import { MapCmpComponent } from './map-cmp/map-cmp.component';
import { SupportCmpComponent } from './support-cmp/support-cmp.component';
import { ScheduleCmpComponent } from './schedule-cmp/schedule-cmp.component';
import { HomeCmpComponent } from './home-cmp/home-cmp.component';
import { LoginCmpComponent } from './login-cmp/login-cmp.component';
import { FooterCmpComponent } from './footer-cmp/footer-cmp.component';
import { LoginService } from './services/login.service';

const appRoutes: Routes = [
  {path: 'app-administration', component: LoginCmpComponent},
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
    FooterCmpComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
