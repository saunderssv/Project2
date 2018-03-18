import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bar-cmp',
  templateUrl: './bar-cmp.component.html',
  styleUrls: ['./bar-cmp.component.css']
})
export class BarCmpComponent implements OnInit {
  width = 600;
    height = 400;
    type = 'column2d';
    dataFormat = 'json';
    dataSource;

  constructor() {
    this.dataSource = this.dataSource = {
      "chart": {
          "caption": "Animal Popularity",
          "subCaption": "Top 5 popular animals this year",
        //   "numberprefix": "$",
          "theme": "fint"
      },
      "data": [
          {
              "label": "Lion",
              "value": "10"
          },
          {
              "label": "Panda",
              "value": "5"
          },
          {
              "label": "American Bison",
              "value": "3"
          },
          {
              "label": "Alligators",
              "value": "9"
          },
          {
              "label": "Apes",
              "value": "20"
          }
      ]
  }
   }

  ngOnInit() {
  }

}
