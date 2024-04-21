import { Component } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonCard, IonGrid, IonRow, IonCol } from '@ionic/angular/standalone';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss'],
  standalone: true,
  imports: [IonCol, IonRow, IonGrid, IonCard, IonHeader, IonToolbar, IonTitle, IonContent]
})
export class Tab2Page {

  constructor() {}

}
