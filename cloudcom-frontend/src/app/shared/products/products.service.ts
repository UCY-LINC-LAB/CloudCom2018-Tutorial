import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }


  getAll(): Observable<any> {
    return this.http.get('http://10.16.3.98:10012/api/v1/all');
  }

  getBook(bookid: string): Observable<any> {
    return this.http.get('http://10.16.3.98:10012/api/v1/product/' + bookid);
  }

}
