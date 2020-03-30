import {Player} from './player.model';
import {TeamStatistics} from './teamStatistics.model';

export interface Team {
  id: number;
  name: string;
  players: Player[];
  teamStatistics: TeamStatistics;
}
