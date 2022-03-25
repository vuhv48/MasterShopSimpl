import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { IOrder } from '../order.model';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'jhi-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.scss'],
})
export class OrderDetailComponent implements OnInit {
  orders?: IOrder[];
  isLoading = false;

  constructor(protected orderService: OrderService, protected modalService: NgbModal) {
    console.log('constructor order detail component...');
  }

  ngOnInit(): void {
    this.loadAll();
  }

  loadAll(): void {
    this.isLoading = true;

    this.orderService.getMyOrders().subscribe({
      next: (res: HttpResponse<IOrder[]>) => {
        this.isLoading = false;
        this.orders = res.body ?? [];
        console.log('order detail component ts ok ok...');
      },
      error: () => {
        this.isLoading = false;
      },
    });
  }
}
