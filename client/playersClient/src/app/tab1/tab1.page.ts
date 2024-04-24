import { Component, inject } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import { person } from 'ionicons/icons';
import { Player } from '../model/Player';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../services/apiService.service';



@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: true,
  imports: [IonicModule,FormsModule],
})

export class Tab1Page {
  public icons = { person }

  public player:Player = new Player()

  
  constructor(
    private apiService:ApiService
  ) {
    
  }

  register() {
    console.log(this.player)
    this.apiService.savePlayer(this.player)

  }
}
