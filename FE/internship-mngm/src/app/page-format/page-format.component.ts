import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-format',
  templateUrl: './page-format.component.html',
  styleUrls: ['./page-format.component.scss']
})
export class PageFormatComponent implements OnInit {

  isExpanded = true;
  isShowing = false;

  constructor() { }

  ngOnInit(): void {
  }

  mouseenter() {
    if (!this.isExpanded) {
      this.isShowing = true;
    }
  }

  mouseleave() {
    if (!this.isExpanded) {
      this.isShowing = false;
    }
  }

}
