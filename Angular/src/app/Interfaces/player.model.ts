import {User} from "./user.model";

export interface Player {
  id?: number;
  age: number;
  countryBirth: string,
  height: number;
  weight: number;
  speed: number;
  strength: number;
  endurance: number;
  pace: number;
  accuaracy: number;
  aceleration: number;
  idUser?: number;
  user?:User;
}
