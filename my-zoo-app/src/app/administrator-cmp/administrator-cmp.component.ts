import { Component, OnInit } from '@angular/core';
import { Zookeeper } from '../domain/zookeeper';
import { Animal } from '../domain/animal';
import {Http, Headers, RequestOptions} from '@angular/http';
import { LoginService } from '../services/login.service';
import { HttpHeaders } from '@angular/common/http';




@Component({
  selector: 'app-administrator-cmp',
  templateUrl: './administrator-cmp.component.html',
  styleUrls: ['./administrator-cmp.component.css']
})
export class AdministratorCmpComponent implements OnInit {

  
  
  zookeeper: {};
  animals: Animal[] = [];
  inventory: {}[] = [];

  constructor(private loginService: LoginService,private http: Http) { 
    const headers = new Headers();
    // headers.append('Content-Type', 'application/json');
    headers.append('Authorization', 'Bearer'+ ' '+ localStorage.getItem('token'));

   const options = new RequestOptions({headers: headers});
    var body = { "employeeId": 7}
    this.http.post('https://zootropolis.herokuapp.com/users/info',body, options).map (
      (response) => response.text()
    ).subscribe (
      (data) => {console.log(data)}
    )

  }

  ngOnInit() {
    
    //dummydata
    this.zookeeper = new Zookeeper( localStorage.getItem("Username"), "Testing", "Testing2", localStorage.getItem("Role"));
    this.animals.push(new Animal(1, "M", "Bear", "Yogi", "Eats way too much", "anything" ));
    this.animals.push(new Animal(2, "M", "Orangutan", "Dunston", "mischevious", "bananas"));
    this.animals.push(new Animal(3, "F", "Wolf", "Akeelah", "Alpha", "red meat"));

    this.inventory.push({id: 1, item: "Bananas", quantity: "50Kg", next: "2018-03-31", notes: ""});
    this.inventory.push({id: 1, item: "Red Meat", quantity: "232Kg", next: "2018-04-06", notes: "store quickly"});

  }
}
