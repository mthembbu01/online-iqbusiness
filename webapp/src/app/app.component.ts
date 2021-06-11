import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  name = 'skola-app';
  selectedDisplay = 'login';

  onNavigate(selected: string): void {
    this.selectedDisplay = selected;
  }

  ngOnInit(): void {
  }
}
