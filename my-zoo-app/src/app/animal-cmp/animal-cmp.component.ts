import { Component, OnInit } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-animal-cmp',
  templateUrl: './animal-cmp.component.html',
  styleUrls: ['./animal-cmp.component.css']
})
export class AnimalCmpComponent implements OnInit {

  httpdata;
  constructor(private http: Http) {
    const headers = new Headers();
    headers.append('Authorization', 'Bearer'+ ' '+ localStorage.getItem('token'));
    const options = new RequestOptions({headers: headers});
    var body = { "employeeId": localStorage.getItem("Id")}
    this.http.post('https://zootropolis.herokuapp.com/Animal/empAnimals',body, options).
    map (
      (response) => response.text()
    ).subscribe (
      (data) => {this.httpdata = JSON.parse(data)}
    )
   }

  ngOnInit() {
  }

}
