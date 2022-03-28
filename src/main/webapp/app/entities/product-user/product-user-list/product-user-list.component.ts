import { CartService } from './../../cart/cart.service';
import { HttpResponse } from '@angular/common/http';
import { IProductUser } from './../product-user.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ProductUserServiceService } from './../product-user-service.service';
import { Component, OnInit } from '@angular/core';
import { takeWhile } from 'rxjs';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'jhi-product-user-list',
  templateUrl: './product-user-list.component.html',
  styleUrls: ['./product-user-list.component.scss'],
})
export class ProductUserListComponent implements OnInit {
  products?: IProductUser[];
  imageToShow: any;
  isLoading = false;
  isImageLoading = false;

  constructor(
    protected productUserService: ProductUserServiceService,
    protected cartService: CartService,
    protected modalService: NgbModal,
    private sanitizer: DomSanitizer
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
    this.cartService.addToCartTest().subscribe(
      () => console.log('add to cart success...'),
      () => {
        this.isLoading = false;
      }
    );
  }
  addToCart(id: number, total: string): void {
    console.log('add to cart backend cua fontend...');
    this.cartService.addToCart(id, total).subscribe(
      () => console.log('add to cart success...'),
      () => {
        this.isLoading = false;
      }
    );
  }

  createImageFromBlob(image: Blob): void {
    const reader = new FileReader();
    reader.addEventListener(
      'load',
      () => {
        this.imageToShow = reader.result;
      },
      false
    );

    //if (image!=null) {
    reader.readAsDataURL(image);
    //}
  }
  getImageFromService(): void {
    this.isImageLoading = true;
    this.productUserService.getImage(1).subscribe(
      data => {
        this.createImageFromBlob(data);
        this.isImageLoading = false;
      },
      error => {
        this.isImageLoading = false;
        console.log(error);
      }
    );
  }

  ngOnInit(): void {
    this.loadAll();
    this.getImageFromService();
  }
}
