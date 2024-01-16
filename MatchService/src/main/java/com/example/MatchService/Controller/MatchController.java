package com.example.MatchService.Controller;

import com.example.MatchService.Model.Match;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Api(value = "MatchController", description = "Operations related to Matchs")
@RestController
@RequestMapping("/matches")
public class MatchController {

    @Value("${team.service.url}")  // Récupère l'URL du microservice Team depuis les propriétés
    private String teamServiceUrl;

    List<Match> matches = new ArrayList<>();

    {
        matches.add(new Match(1,3,5,1,1));
        matches.add(new Match(2,1,2,2,3));
        matches.add(new Match(3,4,6,3,3));
        matches.add(new Match(4,3,1,0,2));
        matches.add(new Match(5,2,4,0,5));
    }

    @HystrixCommand(fallbackMethod = "defaultGreeting")
    @ApiOperation(value = "Get Match By ID", response = List.class, tags = "MatchById")
    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable(value = "id") int id) {
        Match match = matches.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

        if (match != null) {
            // Appeler le microservice Team pour obtenir le nom de l'équipe 1
            String team1Name = getTeamName(match.getIdTeam1());
            match.setTeam1(team1Name);

            // Appeler le microservice Team pour obtenir le nom de l'équipe 2
            String team2Name = getTeamName(match.getIdTeam2());
            match.setTeam2(team2Name);
        }

        return match;
    }

    private String getTeamName(int teamId) {
        // Utiliser RestTemplate pour appeler le microservice Team
        RestTemplate restTemplate = new RestTemplate();
        String teamUrl = teamServiceUrl + "/teams/" + teamId;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(teamUrl, String.class);

        return responseEntity.getBody();
    }



    @ApiOperation(value = "Add a new match", response = Match.class, tags = "AddMatch")
    @PostMapping
    public Match addTeam(@RequestBody Match match) {
        matches.add(match);
        return match;
    }

    @ApiOperation(value = "Update an existing match", response = Match.class, tags = "UpdateMatch")
    @PutMapping("/{id}")
    public void updateMatch(@PathVariable(value = "id") int id, @RequestBody Match updatedMatch) {
        // Recherchez le match existant par ID
        Match existingMatch = matches.stream().filter(match -> match.getId() == id).findFirst().orElse(null);

        // Si le match existe, mettez à jour ses informations
        if (existingMatch != null) {
            existingMatch.setIdTeam1(updatedMatch.getIdTeam1());
            existingMatch.setIdTeam2(updatedMatch.getIdTeam2());
            existingMatch.setScoreTeam1(updatedMatch.getScoreTeam1());
            existingMatch.setScoreTeam2(updatedMatch.getScoreTeam2());
        }
    }

    @ApiOperation(value = "Delete a match by ID", response = Match.class, tags = "DeleteMatch")
    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable(value = "id") int id) {
        // Supprimez le match de la liste en utilisant l'ID
        matches.removeIf(match -> match.getId() == id);
    }

    @SuppressWarnings("unused")
    private Match defaultGreeting(int id) {
        Match match = matches.stream()
                .filter(team -> team.getId() == id)
                .findFirst()
                .orElse(null);

        match.setTeam1("Le service Team est éteint");
        match.setTeam2("Le service Team est éteint");
        return match;
    }
}
