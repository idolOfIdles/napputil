package napputils.no.assignment.controller;

import napputils.no.assignment.model.Crew;
import napputils.no.assignment.model.dto.CrewDto;
import napputils.no.assignment.model.dto.CrewLightDto;
import napputils.no.assignment.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CrewController {

    @Autowired
    private CrewService crewService;

    @GetMapping("/crew/{crewId}")
    public CrewDto getCrew(@PathVariable String crewId) {
        return crewService.getCrew(crewId);
    }

    @PostMapping(path = "/crew")
    public CrewDto insertCrew(@RequestBody Crew crew) {
        return crewService.insert(crew);
    }

    @PutMapping("/crew")
    public CrewDto update(@RequestBody Crew crew) {
        return crewService.update(crew);
    }

    @GetMapping("/crew/list")
    public List<CrewLightDto> list() {
        return crewService.getCrewList();
    }

}
