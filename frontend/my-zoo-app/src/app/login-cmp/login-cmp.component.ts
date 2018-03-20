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

 
  constructor(private router: Router,private http: Http) { }

  ngOnInit() {
  }



  onClickSubmit(event){

    var token = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJtYW5hZ2VyIiwic3ViIjoiS2ltIiwiaXNzIjoiWm9vdHJvcG9saXMiLCJleHAiOjE1MjIzNTA2NTl9.kWpv_TUTxkVZZoZKFMegaNFI9q4zR64vP-4pSLfQVGFkqzZr97r5EJJ8zqEvRNJ_hG-n2aUocAkVwAfQ_8Ltcw'
    var data2 = jwtDecode(token);
    console.log(data2);
    localStorage.setItem("Username",data2['sub']);
    localStorage.setItem("Password",data2['iss']);


    // var body = { "username":this.username,"password":this.password}

    // console.log(body)
    // this.http.post('https://zootropolis.herokuapp.com/users/signin',body).
    // map (
    //   (response) => response.text()
    // ).subscribe (
    //   (data) => {console.log(data)}
    // )
   this.router.navigate(['app-administrator-cmp'])
  }

  // submitData(data){
    // var token = data;
    // var data2 = jwtDecode(token);
    // console.log(data2);
  // }


}
