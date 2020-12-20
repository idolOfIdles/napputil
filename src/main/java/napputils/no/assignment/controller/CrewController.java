package napputils.no.assignment.controller;

import napputils.no.assignment.model.Crew;
import napputils.no.assignment.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@RestController("/api")
public class CrewController {

    @Autowired
    private CrewService crewService;

    @GetMapping("/crew/{crewId}")
    public Crew getCrew(@PathVariable String crewId){
        return crewService.getCrew(crewId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
