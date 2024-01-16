package com.example.Emre.Controller;

import com.example.Emre.Model.Team;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "TeamController", description = "Operations related to Teams")
@RestController
@RequestMapping("/teams") // Ajout d'une annotation pour définir le chemin de base pour toutes les méthodes de ce contrôleur
public class TeamController {

    List<Team> teams = new ArrayList<>();

    {
        teams.add(new Team(1, "Kayserispor", "Kayseri"));
        teams.add(new Team(2, "PSG", "Paris"));
        teams.add(new Team(3, "Nice", "Nice"));
        teams.add(new Team(4, "USO", "Orleans"));
        teams.add(new Team(5, "ASM", "Monaco"));
        teams.add(new Team(6, "FCB", "Barcelone"));
        teams.add(new Team(7, "RM", "Madrid"));
    }
    @ApiOperation(value = "Get Team By ID", response = List.class, tags = "TeamById")
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable(value = "id") int id) {
        return teams.stream()
                .filter(team -> team.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @ApiOperation(value = "Add a new Team", response = Team.class, tags = "AddTeam")
    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        teams.add(team);
        return team;
    }

    @ApiOperation(value = "Update an existing Team", response = Team.class, tags = "UpdateTeam")
    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable(value = "id") int id, @RequestBody Team updatedTeam) {
        Team existingTeam = teams.stream()
                .filter(team -> team.getId() == id)
                .findFirst()
                .orElse(null);

        if (existingTeam != null) {
            // Mettez à jour les informations de l'équipe existante avec les nouvelles informations
            existingTeam.setName(updatedTeam.getName());
            existingTeam.setCity(updatedTeam.getCity());
        }

        return existingTeam;
    }

    @ApiOperation(value = "Delete a Team by ID", response = Team.class, tags = "DeleteTeam")
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable(value = "id") int id) {
        teams.removeIf(team -> team.getId() == id);
    }
}
