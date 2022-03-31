import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'student',
        data: { pageTitle: 'shopSimple2022T3App.student.home.title' },
        loadChildren: () => import('./student/student.module').then(m => m.StudentModule),
      },
      {
        path: 'product-shop',
        data: { pageTitle: 'shopSimple2022T3App.student.home.title' },
        loadChildren: () => import('./product-user/product-user.module').then(m => m.ProductUserModule),
      },
      {
        path: 'cart',
        data: { pageTitle: 'shopSimple2022T3App.student.home.title' },
        loadChildren: () => import('./cart/cart.module').then(m => m.CartModule),
      },
      {
        path: 'order',
        data: { pageTitle: 'shopSimple2022T3App.student.home.title' },
        loadChildren: () => import('./order/order.module').then(m => m.OrderModule),
      },
      {
        path: 'customer-orderitem',
        data: { pageTitle: 'shopSimple2022T3App.student.home.title' },
        loadChildren: () => import('./orderitem/orderitem.module').then(m => m.OrderitemModule),
      },
      {
        path: 'product-admin',
        data: { pageTitle: 'shopSimple2022T3App.student.home.title' },
        loadChildren: () => import('./product-admin/product-admin.module').then(m => m.ProductAdminModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
