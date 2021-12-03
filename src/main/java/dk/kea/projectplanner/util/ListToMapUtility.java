package dk.kea.projectplanner.util;

import dk.kea.projectplanner.models.Activity;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapUtility {

    public static <P extends Activity> Map<Long, P> listToMap(List<P> list) {
        return list.stream().collect(Collectors.toMap(Activity::getId, Function.identity()));
    }
}
