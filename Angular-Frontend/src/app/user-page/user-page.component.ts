import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RoutingModule } from '../../routing.module';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  username;
  password;

  loginForm={
    "username":'',
    "password":''
  }

  constructor(private activeRoute: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  login(username,password){
    //implement here the login logic
    this.loginForm.username = username.value;
    this.loginForm.password = password.value;

    console.log(this.loginForm);
    this.router.navigate(['users/list']);
  }

}
