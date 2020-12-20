package napputils.no.assignment.service;

import napputils.no.assignment.model.Crew;
import napputils.no.assignment.repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrewService {
    @Autowired
    public CrewRepository repository;

    public Optional<Crew> getCrew(String id) {
        return repository.findById(id);
    }

    public List<Crew> getCrewList() {
        return repository.findAll();
    }

    public Crew insert(Crew crew) {
        return repository.insert(crew);
    }

    public Crew update(Crew crew) {
        return repository.save(crew);
    }
}
