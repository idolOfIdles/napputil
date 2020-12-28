package napputils.no.assignment.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Document(collection = "crew")
@Data
@EqualsAndHashCode(callSuper = false)
public class Crew extends BaseModel {

    @Id
    private String crewId;

    @NotNull
    private Name name;

    @Min(value = 0, message = "Positive number")
    private Short age;

    private String job;

    @Min(value = 0, message = "Positive number and unit is in kilogram")
    private Float weight;

    @Min(value = 0, message = "Positive number and unit is in centimeter")
    private Short height;

    private String desc;

    @Override
    public String getId() {
        return crewId;
    }

    @Override
    public boolean isNew() {
        return crewId == null;
    }
}
