import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private router: Router) {

  }

  goToSexes() {
    this.router.navigateByUrl('sexes');
  }

  goToGenres() {
    this.router.navigateByUrl('genres');
  }
}
