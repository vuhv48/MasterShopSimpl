import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CartRoutingModule } from './cart-routing.module';
import { SharedModule } from 'app/shared/shared.module';
import { CartDetailComponent } from './cart-detail/cart-detail.component';

@NgModule({
  declarations: [CartDetailComponent],
  imports: [SharedModule, CommonModule, CartRoutingModule],
})
export class CartModule {}
