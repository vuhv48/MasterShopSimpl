import { CartService } from './../../cart/cart.service';
import { HttpResponse } from '@angular/common/http';
import { IProductUser } from './../product-user.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ProductUserServiceService } from './../product-user-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-product-user-list',
  templateUrl: './product-user-list.component.html',
  styleUrls: ['./product-user-list.component.scss'],
})
export class ProductUserListComponent implements OnInit {
  products?: IProductUser[];
  isLoading = false;
  constructor(
    protected productUserService: ProductUserServiceService,
    protected cartService: CartService,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.isLoading = true;
    this.productUserService.query().subscribe({
      next: (res: HttpResponse<IProductUser[]>) => {
        this.isLoading = false;
        this.products = res.body ?? [];
      },
      error: () => {
        this.isLoading = false;
      },
    });
  }

  testClick(): void {
    console.log('test click ok');
    this.isLoading = true;
    this.cartService.addToCart().subscribe(
      () => console.log('add to cart success...'),
      () => {
        this.isLoading = false;
      }
    );
  }

  ngOnInit(): void {
    this.loadAll();
  }
}
