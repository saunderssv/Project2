import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import * as jwtDecode from "jwt-decode";

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

  // myUserLogin(event){
  //   var body = "uname"+this.username+
  // }
  
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
    var token = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJtYW5hZ2VyIiwic3ViIjoiS2ltIiwiaXNzIjoiWm9vdHJvcG9saXMiLCJleHAiOjE1MjIzNTA2NTl9.kWpv_TUTxkVZZoZKFMegaNFI9q4zR64vP-4pSLfQVGFkqzZr97r5EJJ8zqEvRNJ_hG-n2aUocAkVwAfQ_8Ltcw'
    var decoded = jwtDecode(token);
    console.log(decoded);


    // var body = { "username":"Kim","password":"lol"}

    // console.log(body)
    // this.http.put('https://zootropolis.herokuapp.com/users/signin',body).
    // map (
    //   (response) => response.text()
    // ).subscribe (
    //   (data) => {console.log(data)}
    // )
    // this.router.navigate(['app-administrator-cmp'])
  }


}
