package napputils.no.assignment.model.dto;

import lombok.Data;
import napputils.no.assignment.model.Crew;

@Data
public class CrewLightDto {
    private String name;
    private Short age;
    private String job;

    public static CrewLightDto convert(Crew crew) {
        CrewLightDto crewDto = new CrewLightDto();
        crewDto.setName(crew.getName());
        crewDto.setAge(crew.getAge());
        crewDto.setJob(crew.getJob());
        return crewDto;
    }

}
