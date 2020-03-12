import {Match} from './match.model';
import {TeamMatch} from './teamMatch.model';

export interface Tournament {
  id: number;
  name: string;
  nonspacename: string;
  matchs: Match[];
  teams: TeamMatch[];
}
