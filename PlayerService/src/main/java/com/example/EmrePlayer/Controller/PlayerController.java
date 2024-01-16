package com.example.EmrePlayer.Controller;

import com.example.EmrePlayer.Model.Player;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Api
@RestController
@RequestMapping("/players")
public class PlayerController {

    @Value("${team.service.url}")  // Récupère l'URL du microservice Team depuis les propriétés
    private String teamServiceUrl;


    List<Player> players = new ArrayList<>();

    {
        players.add(new Player(1, "Emre", 38, "BU", 3));
        players.add(new Player(2, "Christophe", 1, "GK", 2));
        players.add(new Player(3, "Martin", 5, "DD",1));
        players.add(new Player(4, "Kazim", 13, "DG", 1));
        players.add(new Player(5, "Mahmut", 65, "MO", 3));
        players.add(new Player(6, "Jean-Charles", 24, "MC", 2));
    }

    @HystrixCommand(fallbackMethod = "defaultGreeting")
    @ApiOperation(value = "Get Player By ID", response = List.class, tags = "PlayerById")
    @GetMapping("/{id}")
    public Player getPLayerById(@PathVariable(value = "id") int id) {
        Player player = players.stream()
                .filter(team -> team.getId() == id)
                .findFirst()
                .orElse(null);

        if (player != null) {
            // Appeler le microservice Team pour obtenir le nom de l'équipe
            String teamName = getTeamName(player.getTeamId());
            player.setTeamName(teamName);
        }

        return player;
    }
    @ApiOperation(value = "Add a new Player", response = Player.class, tags = "AddPlayer")
    @PostMapping
    public void addPlayer(@RequestBody Player player) {
        players.add(player);
    }

    @ApiOperation(value = "Update an existing Player", response = Player.class, tags = "UpdatePlayer")
    @PutMapping("/{id}")
    public void updatePlayer(@PathVariable int id, @RequestBody Player updatedPlayer) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == id) {
                players.set(i, updatedPlayer);
                return;
            }
        }
    }
    @ApiOperation(value = "Delete a Player by ID", response = Player.class, tags = "DeletePlayer")
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }
    private String getTeamName(int teamId) {
        // Utiliser RestTemplate pour appeler le microservice Team
        RestTemplate restTemplate = new RestTemplate();
        String teamUrl = teamServiceUrl + "/teams/" + teamId;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(teamUrl, String.class);

        return responseEntity.getBody();
    }

    @SuppressWarnings("unused")
    private Player defaultGreeting(int id) {
        Player player = players.stream()
                .filter(team -> team.getId() == id)
                .findFirst()
                .orElse(null);

        player.setTeamName("Le service Team est éteint");
        return player;
    }

}
