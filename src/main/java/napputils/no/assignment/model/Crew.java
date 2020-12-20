package napputils.no.assignment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "crew")
@Data public class Crew {
    @Id private String crewId;
    private String Name;
    private Short age;
    private String job;
    private String weight;
    private String desc;
}
