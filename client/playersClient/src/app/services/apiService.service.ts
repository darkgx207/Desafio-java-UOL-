import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Player } from '../model/Player';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  public api:string = environment.apiURL

  constructor(
    private http:HttpClient
  ) { }


  getAllPlayers() {
    this.http.get(`${this.api}/player`).subscribe( res => {
      console.log(res)
    })
  }


  savePlayer(player:Player) {
    this.http.post(`${this.api}/player`, player).subscribe( res => {
      console.log(res)
    })
  }


}
