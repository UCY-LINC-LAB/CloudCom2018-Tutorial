import { Component, OnInit } from '@angular/core';
import {ProductsService} from '../shared/products/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {


  products: Array<any>;
  ratings = [];
  sum = 0;


  constructor(private productsService: ProductsService) { }

  ngOnInit() {
    this.productsService.getAll().subscribe(data => {
      this.products = data;
      for (const book of this.products){
        this.sum = 0;
        for (const rating of book.ratings){
          this.sum = rating.rating + this.sum;
          this.ratings.push(this.sum);
        }
      }

    });
  }

}
