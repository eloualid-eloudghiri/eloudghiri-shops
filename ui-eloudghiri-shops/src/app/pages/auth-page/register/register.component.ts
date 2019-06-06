import {Component, Input, OnInit} from '@angular/core';
import {AuthPageComponent} from '../auth-page.component';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from '../../../shared/models/user.model';
import {Coordinate} from '../../../shared/models/coordinate.model';
import {UsersService} from '../../../services/users.service';
import {Router} from '@angular/router';
import {EmailOrEmptyValidators} from '../../../shared/validators/email-or-empty.validators';
import {TelephoneValidators} from '../../../shared/validators/telephone.validators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  @Input() parrent: AuthPageComponent;

  private registerFormGroup: FormGroup = new FormGroup({
    lastname: new FormControl('', Validators.required),
    firstname: new FormControl('', Validators.required),
    telephone: new FormControl('', [Validators.required, TelephoneValidators.portableAndFixe]),
    email: new FormControl('', [Validators.required, EmailOrEmptyValidators.emailOrEmpty]),
    password: new FormControl('', [Validators.required, Validators.maxLength(32), Validators.minLength(8)]),
    coordinateX: new FormControl('', Validators.required),
    coordinateY: new FormControl('', Validators.required)
  });

  constructor(private usersService: UsersService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    const user: User = new User(
        null,
        this.registerFormGroup.controls.lastname.value,
        this.registerFormGroup.controls.firstname.value,
        this.registerFormGroup.controls.email.value,
        this.registerFormGroup.controls.telephone.value,
        this.registerFormGroup.controls.password.value,
        null,
        new Coordinate(
            null,
            this.registerFormGroup.controls.coordinateX.value,
            this.registerFormGroup.controls.coordinateY.value
        )
    );
    console.log(user);
    this.usersService.register(user).subscribe(
        (data) => {
          console.log('data : ' + data);
        }
    );
    this.parrent.wantToResigterHandler();
    window.alert('registration completed ! :)');
  }
}
