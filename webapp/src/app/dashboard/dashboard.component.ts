import { Component, OnInit } from '@angular/core';
import {Person} from '../shared/person.model';
import {RegisterService} from '../register/register.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  registeredPersons: Person[] = [];
  constructor(private registerService: RegisterService) { }

  ngOnInit(): void {
      this.registerService.getUsers().subscribe(
          persons => this.registeredPersons = persons
      );
  }
}
