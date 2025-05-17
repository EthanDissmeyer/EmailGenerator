import { Component, ElementRef, AfterViewChecked, inject } from '@angular/core';
import { Router, NavigationEnd, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements AfterViewChecked {

  private el = inject(ElementRef);

  ngAfterViewChecked() {
    this.updateIndicator();
  }

  private updateIndicator() {
    const indicator = this.el.nativeElement.querySelector('#navIndicator');
    const activeLink = this.el.nativeElement.querySelector('.nav-link.active');

    if (indicator && activeLink) {
      const { offsetLeft, offsetWidth } = activeLink;
      indicator.style.left = `${offsetLeft}px`;
      indicator.style.width = `${offsetWidth}px`;
    }
  }
}
