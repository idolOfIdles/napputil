package napputils.no.assignment.model.crew;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import napputils.no.assignment.util.StringUtil;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Name {
    @NotNull
    @NonNull
    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public String toString() {
        return String.join(" ",
                firstName,
                StringUtil.toNullOrEmpty(middleName),
                StringUtil.toNullOrEmpty(lastName));
    }
}
