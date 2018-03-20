import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-map-cmp',
  templateUrl: './map-cmp.component.html',
  styleUrls: ['./map-cmp.component.css']
})
export class MapCmpComponent implements OnInit {
  lat: number = 38.931001;
  lng: number = -77.0512221;
  
   data: {}[] = [{lat: 38.9299392, lng: -77.0476189}, {lat:38.931416, lng: -77.052703}, {lat:38.931215, lng:-77.050295},
  {lat: 38.931103, lng: -77.052868},{lat: 38.930536, lng: -77.049306}, {lat: 38.928624, lng: -77.046737}, {lat: 38.9297635, lng: -77.0475369},
  {lat: 38.9290841, lng: -77.0492791},{lat: 38.930897, lng: -77.053289},{lat: 38.931196, lng: -77.052790}];
  // 38.9297635,-77.0475369
  // Sea Lions 38.9289685,-77.0491182
  // Lions/Tigers 38.928530, -77.046553
  // Great Apes 38.9297559,-77.0477975
  // Farrets/monkeys/Koalas 38.9297585,-77.0482431
  // angelfish/piranha/catfish 38.927767, -77.047766
  // poison frogs/salamander/African Clawed Frog 38.928163, -77.048285

  myclick(event){
    
  }
  constructor() { }

  ngOnInit() {
  
  }

}
