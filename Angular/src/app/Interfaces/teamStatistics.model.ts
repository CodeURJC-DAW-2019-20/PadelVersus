import {Game} from "./game.model";

export interface TeamStatistics{
  totalGames: number;
  totalWins: number;
  totalDefeats: number;
  totalAcurracy: number;
  totalEffectiveness: number;
  totalGamesWon: number;
  totalUnforcedErrors: number;
  gamesPerMatch: Game[];
}
