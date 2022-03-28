import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { OrderitemDetailComponent } from './orderitem-detail/orderitem-detail.component';

const routes: Routes = [
  {
    path: ':orderId',
    component: OrderitemDetailComponent,
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class OrderitemRoutingModule {}
