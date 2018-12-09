import { Component, OnInit } from '@angular/core';
import {ProductsService} from '../../shared/products/products.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  book: [];

  constructor(private productsService: ProductsService, private route: ActivatedRoute) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.productsService.getBook(id).subscribe(data => {
      this.book = data;
    });
  }

}
