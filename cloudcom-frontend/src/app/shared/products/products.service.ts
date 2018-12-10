import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  apigateway = 'http://apigateway.localhost/api/v1';

  constructor(private http: HttpClient) { }


  getAll(): Observable<any> {
    return this.http.get(this.apigateway+'/all');
  }

  getBook(bookid: string): Observable<any> {
    return this.http.get(this.apigateway+'/product/' + bookid);
  }

}
