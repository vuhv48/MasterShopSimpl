import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ProductUserServiceService } from 'app/entities/product-user/product-user-service.service';
import { IProductUser } from 'app/entities/product-user/product-user.model';

@Component({
  selector: 'jhi-product-admin-detail',
  templateUrl: './product-admin-detail.component.html',
  styleUrls: ['./product-admin-detail.component.scss'],
})
export class ProductAdminDetailComponent implements OnInit {
  isLoading = false;
  products?: IProductUser[];
  constructor(protected modalService: NgbModal, protected productUserService: ProductUserServiceService) {}
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

  ngOnInit(): void {
    this.loadAll();
  }
}
