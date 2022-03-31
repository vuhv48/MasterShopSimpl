import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { OrderService } from 'app/entities/order/service/order.service';
import { ICartItem } from '../cart.model';
import { CartService } from '../cart.service';

@Component({
  selector: 'jhi-cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.scss'],
})
export class CartDetailComponent implements OnInit {
  cartItems?: ICartItem[];
  size: number | null = 0;
  isLoading = false;
  price?: number;
  totalAllProductInCart: number | null = 0;

  constructor(protected cartService: CartService, protected orderService: OrderService, protected modalService: NgbModal) {}

  ngOnInit(): void {
    console.log('ngOninit cart detail component... ');
    this.getDataInCart();
  }

  getDataInCart(): void {
    console.log('backend cua fontend component cart');

    this.cartService.getDataInCart().subscribe({
      next: (res: HttpResponse<ICartItem[]>) => {
        this.isLoading = true;
        this.cartItems = res.body ?? [];
        this.size = this.cartItems.length;
        console.log(this.cartItems);
      },
      error: () => {
        this.isLoading = false;
      },
    });
  }

  testOrder(): void {
    console.log('test orderservice in cart detail...');
    this.orderService.getOrderItemsWithOrderIdAndOrdering().subscribe({
      next: () => {
        this.isLoading = true;
        console.log('ordering api fontend cua backend okok...');
      },
      error: () => {
        this.isLoading = false;
        console.log('ordering api fail...');
      },
    });
  }

  testBackendOrder(): void {
    console.log('test orderservice in cart detail...');
    this.orderService.testBackend().subscribe({
      next: () => {
        this.isLoading = true;
        console.log('ordering api fontend cua backend okok...');
      },
      error: () => {
        this.isLoading = false;
        console.log('ordering api fail...');
      },
    });
  }
}
