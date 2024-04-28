import { Component, inject } from '@angular/core';
import { AlertController, IonicModule } from '@ionic/angular';
import { person } from 'ionicons/icons';
import { Player } from '../model/Player';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../services/apiService.service';
import { MaskitoDirective } from '@maskito/angular';
import { MaskitoOptions, MaskitoElementPredicate } from '@maskito/core';


@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: true,
  imports: [IonicModule,FormsModule,MaskitoDirective],
})

export class Tab1Page {
  readonly phoneMask: MaskitoOptions = { mask : ['(',/\d/,/\d/,')',/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/] }
  readonly maskPredicate: MaskitoElementPredicate = async (el) => (el as HTMLIonInputElement).getInputElement();
  public failedEmail: boolean = false

  constructor(
    private apiService:ApiService,
    private alert:AlertController
  ) {}

  public icons = { person }
  public player:Player = new Player()
  

  async register() {
    this.player.phoneNumber = this.player.phoneNumber?.split('').filter( char => ![')','('].includes(char)).join('')
    this.apiService.savePlayer(this.player).subscribe ({
      next: async res => {
        const header = (res.status == 201) ? 'Sucesso' : 'Erro'
        const msg = (res.status == 201) ? 'Seu jogador foi registrado com sucesso.' : 'Seu jogador não pôde ser registrado.'
        const alert = await this.alert.create({ header: header , message: msg , buttons : ['Close'] })
        alert.present()
  
        this.player = new Player()
      },
      error: async () =>  (await this.alert.create({ header: 'Erro' , message: 'Servidor indisponível' , buttons : ['Close'] })).present() 
    })
  }


  validateEmail(event:Event) {
    this.failedEmail = false
    
    if (!this.player.email?.includes('@')) { this.failedEmail = true }
    if (!this.player.email?.substring(this.player.email.indexOf('@')).includes('.') ) { this.failedEmail = true }
  }
}
