package napputils.no.assignment.util;

import napputils.no.assignment.model.Crew;
import napputils.no.assignment.model.Name;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {

    public static Crew getDummyCrew() {
        Crew crew = new Crew();
        crew.setAge((short) 5);
        crew.setName(new Name("safayat"));
        crew.setDesc("test desc");
        crew.setWeight(25f);
        return crew;
    }

    public static List<Crew> getDummyCrews(int size) {
        List<Crew> crews = new ArrayList<>();
        for(int i=0;i<size;i++){
            Crew crew = new Crew();
            crew.setAge((short) 5);
            crew.setName(new Name(String.valueOf(i)));
            crew.setDesc("test desc");
            crew.setWeight(25f);
            crews.add(crew);
        }
        return crews;
    }

}
