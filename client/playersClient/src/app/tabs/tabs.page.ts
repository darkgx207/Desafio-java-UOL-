import { Component, ElementRef, EnvironmentInjector, inject, ViewChild, viewChild } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import { IonTabs, IonTabBar, IonTabButton, IonIcon, IonLabel } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { triangle, ellipse, square, caretBackOutline, people, personAddOutline, personAdd, peopleSharp} from 'ionicons/icons';

@Component({
  selector: 'app-tabs',
  templateUrl: 'tabs.page.html',
  styleUrls: ['tabs.page.scss'],
  standalone: true,
  imports: [IonTabs,IonTabBar,IonTabButton,IonIcon,IonLabel],
})
export class TabsPage {
  public environmentInjector = inject(EnvironmentInjector);
  public icons = { triangle, ellipse, square,caretBackOutline, peopleSharp, personAdd }
  public selected?:string = 'tab1'
  
  constructor() {}

  
  public getTab(tab:IonTabs):void {
    this.selected = tab.getSelected()
  }

}
