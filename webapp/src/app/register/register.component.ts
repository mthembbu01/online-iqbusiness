import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Person} from '../shared/person.model';
import {RegisterService} from './register.service';
import {Subscription} from 'rxjs';
import {HttpErrorResponse} from '@angular/common/http';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})

export class RegisterComponent {
  user: Person = new Person('', '', '', '');
  err: string;

  constructor(private registerService: RegisterService, private router: Router) {
  }

/*  public register(user: Person): Subscription{
    return this.registerService.addUser(user).subscribe(
      (response: Person) => {
        this.user = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }*/

  onAddUser(registerForm: NgForm): void {
    this.registerService.addUser(registerForm.value).subscribe(
      (response: Person) => {
          this.router.navigate(['dashboard']);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        this.registerService.setErrorMsg(error.message);
        this.err = error.message;
      }
    );
  }
}
