import { Component, OnInit } from '@angular/core';
import { Http, Response, Headers, RequestOptions  } from '@angular/http'; 


@Component({
  selector: 'app-map-cmp',
  templateUrl: './map-cmp.component.html',
  styleUrls: ['./map-cmp.component.css']
})
export class MapCmpComponent implements OnInit {
  test="default";
  httpdata;
  lat: number = 38.931001;
  lng: number = -77.0512221;

  myclick(event){
    
  }
  constructor(private http: Http) {



   }

  ngOnInit() {
    const headers = new Headers();
    headers.append('Authorization', 'Bearer'+ ' '+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJtYW5hZ2VyIiwic3ViIjoiNiIsImlzcyI6Ilpvb3Ryb3BvbGlzIiwiZXhwIjoxNTIyNDU4NTM3fQ.lfnW2eAuW9h6hTEyf9oYLEufAPsZuWuayCmSr1zPD0q-xBXydRDIrio2rDmL4nlpUyq4rr40H6poCmJFaJj0rw");
    const options = new RequestOptions({headers: headers});
    var body = ' '
    this.http.post('https://zootropolis-thankful-quokka.cfapps.io/Location/',body,options).
    map (
      (response) => response.text()
    ).subscribe (
      (data) => {this.displaydata(data)}
    )
  
  }

  displaydata(data){
    this.httpdata = JSON.parse(data);
  }

  update(event){
    this.test="clicked";
  }


}
