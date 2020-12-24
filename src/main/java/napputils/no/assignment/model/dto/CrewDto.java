package napputils.no.assignment.model.dto;

import lombok.Data;
import lombok.NonNull;
import napputils.no.assignment.model.Crew;

@Data public class CrewDto {
    private String id;
    private String name;
    private Short age;
    private String job;
    private Float weight;
    private String desc;

    public static CrewDto convert(Crew crew){
        CrewDto crewDto = new CrewDto();
        crewDto.setName(crew.getName());
        crewDto.setAge(crew.getAge());
        crewDto.setJob(crew.getJob());
        crewDto.setWeight(crew.getWeight());
        crewDto.setDesc(crew.getDesc());
        crewDto.setId(crew.getCrewId());
        return crewDto;
    }
}
