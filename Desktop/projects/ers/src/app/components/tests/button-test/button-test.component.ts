import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-button-test',
    templateUrl: './button-test.component.html',
    styleUrls: ['./button-test.component.css']
})
export class ButtonTestComponent {
    count = 0;

    increment() {
        this.count++;
    }

    isEven(): boolean {
        return this.count % 2 === 0;
    }

    overOneHundred(): boolean {
        return this.count >= 100;
    }
}
