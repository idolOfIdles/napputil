package napputils.no.assignment.repository;

import napputils.no.assignment.model.Crew;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewRepository extends MongoRepository<Crew, String> {

    @Query(fields = "{ 'name' : 1, 'age' : 1, 'job' : 1}")
    List<Crew> findByOrderByCreateDate(Pageable pageable);
}
