package napputils.no.assignment.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import java.time.Instant;

@Data
public abstract class BaseModel implements Persistable<String> {

    @CreatedDate
    public Instant createDate;
    @LastModifiedDate
    public Instant updateDate;
}
