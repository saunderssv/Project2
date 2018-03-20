import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pie-cmp',
  templateUrl: './pie-cmp.component.html',
  styleUrls: ['./pie-cmp.component.css']
})
export class PieCmpComponent implements OnInit {
  width = 600;
  height = 400;
  type = 'pie3d';
  dataFormat = 'json';
  dataSource = {
    "chart": {
      "caption": "Animal Population Proportions",
      "subcaption": "This Year",
      "startingangle": "120",
      "showlabels": "0",
      "showlegend": "1",
      "enablemultislicing": "0",
      "slicingdistance": "15",
      "showpercentvalues": "1",
      "showpercentintooltip": "0",
      "plottooltext": "Age group : $label Total visit : $datavalue",
      "theme": "ocean"
  },
  "data": [
      {
          "label": "Lions",
          "value": "1250400"
      },
      {
          "label": "Alligators",
          "value": "1463300"
      },
      {
          "label": "American Bison",
          "value": "1050700"
      },
      {
          "label": "Pandas",
          "value": "491000"
      }
  ]
  };

  
  constructor() { }

  ngOnInit() {
  }

}
