import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'app-login-cmp',
  templateUrl: './login-cmp.component.html',
  styleUrls: ['./login-cmp.component.css']
})
export class LoginCmpComponent implements OnInit {

 
  constructor(private router: Router) { }

  ngOnInit() {
  }
  
  onClickSubmit(event){
    this.router.navigate(['app-administrator-cmp'])
  }


}
