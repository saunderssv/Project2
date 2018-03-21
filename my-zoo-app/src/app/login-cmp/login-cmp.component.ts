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
    var body = { "username":this.username,"password":this.password}

    this.http.post('https://zootropolis.herokuapp.com/users/signin',body).
    map (
      (response) => response.text()
    ).subscribe (
      (data) => {this.submitData(data)}
    )
   
  }

  submitData(data){
    var token = data;
    var data2 = jwtDecode(token);
    console.log(data2);
    localStorage.setItem("token",data);
    localStorage.setItem("Username",this.username);
    localStorage.setItem("Role",data2['aud']);
    localStorage.setItem("Id",data2['sub']);
    this.router.navigate(['app-administrator-cmp'])
  }


}
