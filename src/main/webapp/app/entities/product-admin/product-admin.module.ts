import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductAdminRoutingModule } from './product-admin-routing.module';
import { ProductAdminListComponent } from './product-admin-list/product-admin-list.component';
import { ProductAdminUpdateComponent } from './product-admin-update/product-admin-update.component';

@NgModule({
  declarations: [ProductAdminListComponent, ProductAdminUpdateComponent],
  imports: [CommonModule, ProductAdminRoutingModule],
})
export class ProductAdminModule {}
