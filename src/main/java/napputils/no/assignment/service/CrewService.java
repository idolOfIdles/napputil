package napputils.no.assignment.service;

import napputils.no.assignment.model.crew.Crew;
import napputils.no.assignment.model.crew.dto.CrewDto;
import napputils.no.assignment.model.crew.dto.CrewLightDto;
import napputils.no.assignment.repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrewService {
    @Autowired
    public CrewRepository repository;

    public CrewDto getCrew(String id) {
        Crew crew = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return CrewDto.convert(crew);
    }

    public List<CrewLightDto> getCrewList(int page, int size) {
        return repository.findByOrderByCreateDate(PageRequest.of(page, size))
                .stream()
                .map(crew -> CrewLightDto.convert(crew))
                .collect(Collectors.toList());
    }

    public CrewDto insert(Crew crew) {
        return CrewDto.convert(repository.insert(crew));
    }

    public CrewDto update(Crew crew) {
        if(crew.isNew()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return CrewDto.convert(repository.save(crew));
    }
}
