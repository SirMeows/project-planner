package dk.kea.projectplanner.util;

import dk.kea.projectplanner.models.ActivityModel;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapUtility {

    public static <P extends ActivityModel> Map<Long, P> listToMap(List<P> list) {
        return list.stream().collect(Collectors.toMap(ActivityModel::getId, Function.identity()));
    }
}
