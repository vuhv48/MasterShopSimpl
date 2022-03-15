import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.scss'],
})
export class CartDetailComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {
    console.log('okok');
  }
}
