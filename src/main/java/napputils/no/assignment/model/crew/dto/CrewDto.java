package napputils.no.assignment.model.crew.dto;

import lombok.Data;
import napputils.no.assignment.model.crew.Crew;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Data public class CrewDto {
    private String id;
    private String name;
    private Short age;
    private String job;
    private Float weight;
    private String desc;
    private Short height;
    private String createDate;

    public static CrewDto convert(Crew crew){
        CrewDto crewDto = new CrewDto();
        crewDto.setName(crew.getName().toString());
        crewDto.setAge(crew.getAge());
        crewDto.setJob(crew.getJob());
        crewDto.setWeight(crew.getWeight());
        crewDto.setDesc(crew.getDesc());
        crewDto.setId(crew.getCrewId());
        crewDto.setHeight(crew.getHeight());
        crewDto.setCreateDate(
                DateTimeFormatter
                        .ISO_INSTANT
                        .format(Optional.ofNullable(crew.getCreateDate()).orElse(Instant.now())
                        .truncatedTo(ChronoUnit.SECONDS))
        );
        return crewDto;
    }
}
