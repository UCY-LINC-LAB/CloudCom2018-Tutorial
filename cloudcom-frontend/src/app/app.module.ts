import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {FormsModule} from '@angular/forms';
import { ProductsComponent } from './products/products.component';
import { AppRoutingModule } from './app-routing.module';
import {
  MatBadgeModule,
  MatButtonModule,
  MatCardModule, MatChipsModule,
  MatFormFieldModule, MatGridListModule, MatIconModule,
  MatInputModule,
  MatListModule, MatProgressSpinnerModule,
  MatTableModule, MatTabsModule,
  MatToolbarModule
} from '@angular/material';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AuthenticationService} from './shared/authentication/authentication.service';
import {JwtInterceptor} from './interceptors/jwt.interceptor';
import {ProductsService} from './shared/products/products.service';
import {AuthGuard} from './guards/auth.guard';
import { ProductItemComponent } from './products/product-item/product-item.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProductsComponent,
    ProductItemComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatToolbarModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatListModule,
    MatButtonModule,
    MatTableModule,
    MatGridListModule,
    MatProgressSpinnerModule,
    MatIconModule,
    MatBadgeModule,
    MatChipsModule,
    MatTabsModule,
    BrowserAnimationsModule

  ],
  providers: [
    AuthenticationService,
    AuthGuard,
    ProductsService,
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

