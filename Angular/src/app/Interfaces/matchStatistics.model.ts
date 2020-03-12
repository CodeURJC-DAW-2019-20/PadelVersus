import {Set} from './set.model';

export interface MatchStatistics {
  acurracy: number;
  effectiveness: number;
  games_wins: number;
  unforcedErrors: number;
  win: boolean;
  sets: Set [];
}
