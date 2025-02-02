package napputils.no.assignment.model.crew.dto;

import lombok.Data;
import napputils.no.assignment.model.crew.Crew;

@Data
public class CrewLightDto {
    private String name;
    private Short age;
    private String job;

    public static CrewLightDto convert(Crew crew) {
        CrewLightDto crewDto = new CrewLightDto();
        crewDto.setName(crew.getName().toString());
        crewDto.setAge(crew.getAge());
        crewDto.setJob(crew.getJob());
        return crewDto;
    }

}
