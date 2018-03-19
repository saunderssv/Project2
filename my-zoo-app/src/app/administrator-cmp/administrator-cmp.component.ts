import { Component, OnInit } from '@angular/core';
import { Zookeeper } from '../domain/zookeeper';
import { Animal } from '../domain/animal';

@Component({
  selector: 'app-administrator-cmp',
  templateUrl: './administrator-cmp.component.html',
  styleUrls: ['./administrator-cmp.component.css']
})
export class AdministratorCmpComponent implements OnInit {

  zookeeper: Zookeeper;
  animals: Animal[] = [];
  inventory: {}[] = [];

  constructor() { }

  ngOnInit() {
    //dummydata
    this.zookeeper = new Zookeeper("ParkOwner1", "ParkOwner1", "Peter", "Parker", "ZOO");
    this.animals.push(new Animal(1, "M", "Bear", "Yogi", "Eats way too much", "anything" ));
    this.animals.push(new Animal(2, "M", "Orangutan", "Dunston", "mischevious", "bananas"));
    this.animals.push(new Animal(3, "F", "Wolf", "Akeelah", "Alpha", "red meat"));

    this.inventory.push({id: 1, item: "Bananas", quantity: "50Kg", next: "2018-03-31", notes: ""});
    this.inventory.push({id: 1, item: "Red Meat", quantity: "232Kg", next: "2018-04-06", notes: "store quickly"});

  }

}
