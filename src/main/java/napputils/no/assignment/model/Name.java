package napputils.no.assignment.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class Name{
    @NotNull
    private String firstName;
    private String middleName;
    private String lastName;

    public String getFullName(){
        return firstName
                + (middleName!=null? " " + middleName : "")
                + (lastName!=null? " " + lastName : "");
    }
}
