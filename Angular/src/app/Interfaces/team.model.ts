import {TeamPlayer} from "./teamplayer.model";
import {TeamStatistics} from "./teamStatistics.model";

export interface Team {
  id: number;
  name: string;
  players: TeamPlayer[];
  teamStatistics: TeamStatistics[];
}
