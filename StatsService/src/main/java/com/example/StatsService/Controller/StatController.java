package com.example.StatsService.Controller;


import com.example.StatsService.Model.PlayerStat;
import com.example.StatsService.Model.TeamStats;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatController {
    List<TeamStats> teamStats = new ArrayList<>();
    {
        teamStats.add(new TeamStats(1,42,39,19));
        teamStats.add(new TeamStats(2,39,56,30));
        teamStats.add(new TeamStats(3,22,22,37));
        teamStats.add(new TeamStats(4,10,10,59));
        teamStats.add(new TeamStats(5,34,33,35));
        teamStats.add(new TeamStats(6,11,15,65));
        teamStats.add(new TeamStats(7,40,45,29));

    }
    List<PlayerStat> playerStats = new ArrayList<>();
    {
        playerStats.add(new PlayerStat(1, 15, 3,5,1));
        playerStats.add(new PlayerStat(2, 0, 0,0,0));
        playerStats.add(new PlayerStat(3, 2, 10,3,3));
        playerStats.add(new PlayerStat(4, 5, 15,2,2));
        playerStats.add(new PlayerStat(5, 1, 1,2,0));
        playerStats.add(new PlayerStat(6, 5, 3,4,0));
    }
    @ApiOperation(value = "Get Team stats", response = TeamStats.class, tags = "GetTeamStats")
    @GetMapping("/team-stats/{teamId}")
    public TeamStats getTeamStatById(@PathVariable(value = "teamId") int teamId){
        return teamStats.stream()
                .filter(team -> team.getTeamId() == teamId)
                .findFirst()
                .orElse(null);
    }
    @ApiOperation(value = "Get Player stats", response = PlayerStat.class, tags = "GetPlayerStats")
    @GetMapping("/player-stats/{playerId}")
    public PlayerStat getPlayerStatById(@PathVariable(value = "playerId") int playerId){
        return playerStats.stream()
                .filter(team -> team.getPlayerId() == playerId)
                .findFirst()
                .orElse(null);
    }
}

