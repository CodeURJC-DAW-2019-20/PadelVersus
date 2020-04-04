import {AfterContentInit, Directive, EventEmitter, Output} from '@angular/core';

@Directive({
  // tslint:disable-next-line:directive-selector
  selector: '[after-if]'
})
export class AfterIfDirective implements AfterContentInit {

  constructor() { }
  @Output('after-if')
  public after: EventEmitter<void> = new EventEmitter<void>();

  public ngAfterContentInit(): void {
    // timeout helps prevent unexpected change errors
    setTimeout(() => this.after.next());
  }
}
