import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { IOrderItem } from '../orderitem.model';
import { OrderitemService } from '../service/orderitem.service';

@Component({
  selector: 'jhi-orderitem-detail',
  templateUrl: './orderitem-detail.component.html',
  styleUrls: ['./orderitem-detail.component.scss'],
})
export class OrderitemDetailComponent implements OnInit {
  isLoading = false;
  orderItems?: IOrderItem[];
  constructor(protected orderItemService: OrderitemService, protected modalService: NgbModal) {}

  ngOnInit(): void {
    this.loadAll(10006);
  }
  loadAll(orderId: number): void {
    this.isLoading = true;

    this.orderItemService.getOrderItemWithId(orderId).subscribe({
      next: (res: HttpResponse<IOrderItem[]>) => {
        this.isLoading = false;
        this.orderItems = res.body ?? [];
        console.log('order detail component ts ok ok...');
      },
      error: () => {
        this.isLoading = false;
      },
    });
  }
}
