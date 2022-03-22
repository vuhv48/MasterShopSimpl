import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { IProductUser } from 'app/entities/product-user/product-user.model';
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
  productDTOF?: IProductUser;
  isLoading = false;

  constructor(protected cartService: CartService, protected modalService: NgbModal) {}

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
        //this.productDTOF =  res.body.
        var name = '';
        res.body?.map((item: any) => {
          name = item.IProductUser.name;
        });
        this.size = this.cartItems.length;
      },
      error: () => {
        this.isLoading = false;
      },
    });
  }
}
