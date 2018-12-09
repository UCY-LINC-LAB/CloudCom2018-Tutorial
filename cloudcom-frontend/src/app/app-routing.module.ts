import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {ProductsComponent} from './products/products.component';
import {AuthGuard} from './guards/auth.guard';
import {ProductItemComponent} from './products/product-item/product-item.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'products', component: ProductsComponent, canActivate: [AuthGuard]},
  {path: 'products/:id', component: ProductItemComponent, canActivate: [AuthGuard]},
  {path: '**', redirectTo: 'products'},
]

@NgModule({
  exports: [RouterModule],
  imports: [
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
