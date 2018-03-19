import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { Http, Response } from '@angular/http';

@Component({
  selector: 'app-login-cmp',
  templateUrl: './login-cmp.component.html',
  styleUrls: ['./login-cmp.component.css']
})
export class LoginCmpComponent implements OnInit {

  username: string;
  password: string;
 
  constructor(private router: Router, private http: Http) { }

  ngOnInit() {
  }
  
  // myClickManager(event){
  //   this.http.get('http://localhost:8080/auth?username='+this.username).
  //     map(
  //       (response) => response.text()
  //     ).
  //     subscribe(
  //       (data) => {console.log(data)}
  //     )
   
  //   }


  onClickSubmit(event){
    this.router.navigate(['app-administrator-cmp'])
  }


}
