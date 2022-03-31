import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ProductAdminDetailComponent } from './product-admin-detail/product-admin-detail.component';
import { ProductAdminListComponent } from './product-admin-list/product-admin-list.component';
import { ProductAdminUpdateComponent } from './product-admin-update/product-admin-update.component';

const routes: Routes = [
  {
    path: '',
    component: ProductAdminListComponent,
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ProductAdminUpdateComponent,
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ProductAdminUpdateComponent,
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProductAdminRoutingModule {}
