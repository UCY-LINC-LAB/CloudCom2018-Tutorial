import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../shared/authentication/authentication.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService, private router: Router, private route: ActivatedRoute) { }

  username: string;
  password: string;

  returnUrl: string;

  errorExists = false;
  errorMsg = '';

  ngOnInit() {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }


  onLogin() {
    this.errorExists = false;
    this.errorMsg = '';
    this.authenticationService.login(this.username, this.password).subscribe(
      data => {
        if (data.body.hasOwnProperty('accessToken')) {
          localStorage.setItem('jwttoken', JSON.stringify(data.body['accessToken']));
          console.log(data.body['accessToken']);
          this.router.navigate([this.returnUrl]);
        }
      },
      error => {
        this.errorExists = true;
        this.errorMsg = 'Invalid Credentials';
      }
    );
  }

}
