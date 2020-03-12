export interface TeamTournament {
  id: number;
  name: string;
  gamesWon: number;
  gamesPlayed: number;
  gamesLost: number;
  hasLastMatches: boolean;
  lastMatches: string[];
}
