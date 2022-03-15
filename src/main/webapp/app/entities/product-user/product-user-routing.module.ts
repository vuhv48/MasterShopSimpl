import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ProductUserListComponent } from './product-user-list/product-user-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: ProductUserListComponent,
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProductUserRoutingModule {}
