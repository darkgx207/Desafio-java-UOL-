import { Component, OnInit } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonCard, IonGrid, IonRow, IonCol, IonButton, IonList, IonItem, IonLabel, IonCardTitle, IonCardHeader, IonFab, IonFabButton, IonIcon } from '@ionic/angular/standalone';
import { ApiService } from '../services/apiService.service';
import { IPlayerEntity } from '../model/interfaces/IPlayerEntity';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { refresh } from 'ionicons/icons';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss'],
  standalone: true,
  imports: [
    IonIcon, IonFabButton, IonFab, IonCardHeader, IonCardTitle, IonLabel, IonItem, IonList, IonButton,
    IonCol, IonRow, IonGrid, IonCard, IonHeader, IonToolbar, IonTitle, IonContent,CommonModule
    ]
})
export class Tab2Page implements OnInit{

  public players!: Observable<IPlayerEntity[]>

  public icons = {refresh}

  constructor(
    private apiService:ApiService
  ) {}

  update() {
    this.players = this.apiService.getAllPlayers()
  }

  ngOnInit(): void {
    this.update()
  }



}
