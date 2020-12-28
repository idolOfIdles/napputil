package napputils.no.assignment.util;

import java.util.Optional;

public class StringUtil {

    public static String toNullOrEmpty(String string){
        return Optional.ofNullable(string).orElse("");
    }


}
