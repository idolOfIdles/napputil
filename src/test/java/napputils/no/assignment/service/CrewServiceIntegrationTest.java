package napputils.no.assignment.service;

import napputils.no.assignment.model.crew.Crew;
import napputils.no.assignment.model.crew.dto.CrewDto;
import napputils.no.assignment.model.crew.dto.CrewLightDto;
import napputils.no.assignment.util.IntegrationTestBase;
import napputils.no.assignment.util.TestDataGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

public class CrewServiceIntegrationTest extends IntegrationTestBase {

    @Autowired
    private CrewService crewService;

    @BeforeEach
    void initData() {
    }

    @AfterEach
    void clean() {
        crewService.repository.deleteAll();
    }

    @Test
    void savedCrewShouldMatchWithFetchedCrewWithCorrectId() {
        CrewDto savedCrew = crewService.insert(TestDataGenerator.getDummyCrew());
        CrewDto fetchedCrew = crewService.getCrew(savedCrew.getId());
        Assertions.assertEquals(savedCrew, fetchedCrew);
    }

    @Test
    void shouldThrowExceptionWhenFetchingWithWrongCrewId() {
        Assertions.assertThrows(ResponseStatusException.class, () -> crewService.getCrew(""));

    }

    @Test
    void shouldReturnPaginatedAndSortedCrewList() {
        List<Crew> crews = TestDataGenerator.getDummyCrews(30);
        crews.forEach(crew -> crewService.insert(crew));
        List<CrewLightDto> expectedResult = crews.stream()
                .map(crew -> CrewLightDto.convert(crew))
                .collect(Collectors.toList())
                .subList(10, 20);
        List<CrewLightDto> fetchedCrews = crewService.getCrewList(1, 10);
        Assertions.assertAll(
                () -> Assertions.assertEquals(fetchedCrews.size(), 10),
                () -> Assertions.assertEquals(expectedResult, fetchedCrews)
        );
    }


}
