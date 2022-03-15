import { SharedModule } from './../../shared/shared.module';
import { ProductUserListComponent } from './product-user-list/product-user-list.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductUserRoutingModule } from './product-user-routing.module';

@NgModule({
  declarations: [ProductUserListComponent],
  imports: [SharedModule, CommonModule, ProductUserRoutingModule],
})
export class ProductUserModule {}
