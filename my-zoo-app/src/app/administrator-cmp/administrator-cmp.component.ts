import { Component, OnInit } from '@angular/core';
import { Zookeeper } from '../domain/zookeeper';
import { Animal } from '../domain/animal';
import {Http, Headers, RequestOptions} from '@angular/http';
import { LoginService } from '../services/login.service';
import { HttpHeaders } from '@angular/common/http';
import { Router} from '@angular/router';
import 'rxjs/add/operator/map';



@Component({
  selector: 'app-administrator-cmp',
  templateUrl: './administrator-cmp.component.html',
  styleUrls: ['./administrator-cmp.component.css']
})
export class AdministratorCmpComponent implements OnInit {

  creaturs;
  data2;
  zookeeper: {};
  animals: Animal[] = [];
  inventory: {}[] = [];

  constructor(private loginService: LoginService,private http: Http,private router: Router) { 
    const headers = new Headers();
    headers.append('Authorization', 'Bearer'+ ' '+ localStorage.getItem('token'));
    const options = new RequestOptions({headers: headers});
    var body = { "employeeId": +localStorage.getItem("Id")}
    this.http.post('https://zootropolis.herokuapp.com/users/info',body, options).
    map (
      (response) => response.text()
    ).subscribe (
      (data) => {this.setUserInfo(data)}
    )

  }


  setUserInfo(data){
    var data2 = JSON.parse(data);
    localStorage.setItem("Firstname", data2["firstName"]);
    localStorage.setItem("Lastname",data2["lastName"])    
   

  }

  ngOnInit() {
     this.zookeeper = new Zookeeper( localStorage.getItem("Username"), localStorage.getItem("Firstname"), localStorage.getItem("Lastname"), localStorage.getItem("Role"));
    //dummydata
    this.animals.push(new Animal(1, "M", "Bear", "Yogi", "Eats way too much", "anything" ));
    this.animals.push(new Animal(2, "M", "Orangutan", "Dunston", "mischevious", "bananas"));
    this.animals.push(new Animal(3, "F", "Wolf", "Akeelah", "Alpha", "red meat"));

    this.inventory.push({id: 1, item: "Bananas", quantity: "50Kg", next: "2018-03-31", notes: ""});
    this.inventory.push({id: 1, item: "Red Meat", quantity: "232Kg", next: "2018-04-06", notes: "store quickly"});

  }

  signOut(event){
    alert("Successfully logged out")
    localStorage.removeItem("token")
    this.router.navigate(['app-login-cmp'])
  }
}
