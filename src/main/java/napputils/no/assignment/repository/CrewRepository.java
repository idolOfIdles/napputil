package napputils.no.assignment.repository;

import napputils.no.assignment.model.Crew;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository public interface CrewRepository extends MongoRepository<Crew, String> {
}
