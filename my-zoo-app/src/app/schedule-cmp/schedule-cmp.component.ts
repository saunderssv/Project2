import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-schedule-cmp',
  templateUrl: './schedule-cmp.component.html',
  styleUrls: ['./schedule-cmp.component.css']
})
export class ScheduleCmpComponent implements OnInit {


  schedule: {}[] = [
    {what:"Breakfast with Orangutan", where:"Kampung Sumatra", when:"8:00 AM - 9:30 AM"},
    {what:"Elephants Bathing", where:"Elephant Pool", when:"8:45 AM - 9:00 AM"},
    {what:"Short Animal Presenation", where:"Gaya Restaurant", when:"9:00 AM - 9:15 AM"},
    {what:"Animal Presentation", where:"Kampung Sumatra Stage", when:"10:00 AM - 10:20 AM"}, 
    {what:"The Exotica Wildlife Education", where:"Green Stage", when:"11:15 AM - 11:45 AM"},
    {what:"Tiger Keeper Talk", where:"Tiger Exhibit", when:"11:45 AM - 12:00 PM"},
    {what:"Lemur Keeper Talk", where:"Aviary", when:"12:15 PM - 12:30 PM"},
    {what:"Animal Encounter", where:"Elephant View Restaurant", when:"1:00 PM - 2:00 PM"}
    ];

  constructor() { }

  ngOnInit() {
  }

}
