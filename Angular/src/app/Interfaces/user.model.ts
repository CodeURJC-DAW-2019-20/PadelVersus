
import {Player} from './player.model';

export interface User {
  id: number;
  name: string;
  mail: string;
  roles: string[];
  player: Player;
}
