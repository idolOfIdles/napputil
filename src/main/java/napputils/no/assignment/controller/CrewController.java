package napputils.no.assignment.controller;

import napputils.no.assignment.model.crew.Crew;
import napputils.no.assignment.model.crew.dto.CrewDto;
import napputils.no.assignment.model.crew.dto.CrewLightDto;
import napputils.no.assignment.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public CrewDto insertCrew(@Valid @RequestBody Crew crew) {
        return crewService.insert(crew);
    }

    @PutMapping("/crew")
    public CrewDto update(@Valid @RequestBody Crew crew) {
        return crewService.update(crew);
    }

    @GetMapping("/crew/list")
    public List<CrewLightDto> list(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "10") int size) {
        return crewService.getCrewList(page, size);
    }

}
