import {MatchStatistics} from './matchStatistics.model';
import {TeamMatch} from './teamMatch.model';

export interface Match {
  id: number;
  date: Date;
  played: boolean;
  stadistics_1: MatchStatistics;
  stadistics_2: MatchStatistics;
  teams: TeamMatch [];
}
