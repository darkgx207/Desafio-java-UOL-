import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Player } from '../model/Player';
import { IPlayerEntity} from '../model/interfaces/IPlayerEntity'
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  public api:string = environment.apiURL

  constructor(
    private http:HttpClient
  ) { }


  getAllPlayers() {
    return this.http.get<IPlayerEntity[]>(`${this.api}/player`)
  }


  savePlayer(player:Player) {
    return this.http.post(`${this.api}/player`, player, { observe: 'response' })
  }

}
