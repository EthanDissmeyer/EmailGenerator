import { Component } from '@angular/core';
import { Router } from '@angular/router'
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'client';
  constructor(private router: Router) {}

  // Navigate to the email generator page
  navigateToEmailGenerator(): void {
    this.router.navigate(['/email-generator']);
  }

  // Navigate back to the previous page
  goBack(): void {
    this.router.navigate(['/']); // Adjust the route as needed
  }
}
