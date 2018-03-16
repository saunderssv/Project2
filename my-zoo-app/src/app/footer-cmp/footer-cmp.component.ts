import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-footer-cmp',
  templateUrl: './footer-cmp.component.html',
  styleUrls: ['./footer-cmp.component.css']
})
export class FooterCmpComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  onClickLogin(event){
    this.router.navigate(['app-login-cmp'])
  }


}
