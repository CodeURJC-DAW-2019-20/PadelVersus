import {Player} from './player.model';

export interface User {
  id?: number;
  name: string;
  passwordHash?: string;
  mail: string;
  roles: string[];
  player?: Player;
  authdata?: string;

}
