import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuthenticationService} from '../shared/authentication/authentication.service';
import {Injectable} from '@angular/core';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {


  constructor(public authService: AuthenticationService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    req = req.clone(
      {
        setHeaders: {
          Authorization: `Bearer ${this.authService.getLocalToken()}`
        }
      }
    );

    return next.handle(req);
  }

}
