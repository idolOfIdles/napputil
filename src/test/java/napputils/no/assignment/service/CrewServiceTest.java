package napputils.no.assignment.service;

import napputils.no.assignment.model.Crew;
import napputils.no.assignment.model.dto.CrewDto;
import napputils.no.assignment.model.dto.CrewLightDto;
import napputils.no.assignment.repository.CrewRepository;
import napputils.no.assignment.util.TestDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class CrewServiceTest {

    @Autowired
    private CrewService crewService;

    @MockBean
    private CrewRepository crewRepository;

    @Test
    @DisplayName("Test crew list conversion")
    void testGetCrewList() {
        // Setup our mock repository
        Crew crew = TestDataGenerator.getDummyCrew();
        doReturn(List.of(crew)).when(crewRepository).findByOrderByCreateDate(any());

        // Execute the service call
        List<CrewLightDto> returnedCrew = crewService.getCrewList(0, 10);

        // Assert the response
        Assertions.assertEquals(returnedCrew.get(0), CrewLightDto.convert(crew), "The crew returned was not the same as the mock");
    }


    @Test
    @DisplayName("Test crew conversion")
    void testGetCrew() {
        // Setup our mock repository
        Crew crew = TestDataGenerator.getDummyCrew();
        doReturn(Optional.of(crew)).when(crewRepository).findById(any());

        // Execute the service call
        CrewDto returnedCrew = crewService.getCrew("id");

        // Assert the response
        Assertions.assertEquals(returnedCrew, CrewDto.convert(crew), "The crew returned was not the same as the mock");
    }




}
