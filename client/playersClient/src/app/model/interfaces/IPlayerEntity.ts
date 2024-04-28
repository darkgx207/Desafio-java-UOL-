import { HeroGroup } from "../HeroGroup"

export interface IPlayerEntity {
    id?:number
    name?: string
    email?: string
    phoneNumber?: string
    heroGroup?: HeroGroup
    codiname?:string
}