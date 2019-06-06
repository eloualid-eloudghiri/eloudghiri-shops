import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {UsersService} from '../../../services/users.service';
import {Coordinate} from '../../../shared/models/coordinate.model';
import {UserAuthentification} from '../../../shared/models/user-authentification.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private loginFormGroup: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.required)
  });

  constructor(private usersService: UsersService) { }

  ngOnInit() {
  }

  onSubmit() {
    const userAuthentification: UserAuthentification = new UserAuthentification(
        this.loginFormGroup.controls.email.value,
        this.loginFormGroup.controls.password.value
    );
    this.usersService.login(userAuthentification);
  }

}
