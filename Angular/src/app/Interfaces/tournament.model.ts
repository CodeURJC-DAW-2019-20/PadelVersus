import { TeamMatch } from './teamMatch.model';
import { Match } from './match.model';

export interface Tournament {
  id: number;
  name: string;
  nonspacename: string;
  matches: Match[];
  teams: TeamMatch[];
}
