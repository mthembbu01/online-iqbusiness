import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{
  @Output() selectedOption = new EventEmitter<string>();
  @Output() otherEvt = new EventEmitter();

  onSelect(selected: string): void{
    this.selectedOption.emit(selected);
  }
}
