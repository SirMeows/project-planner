/*
Author He
30.11.2021
 */

package dk.kea.projectplanner.util;

import dk.kea.projectplanner.models.ActivityModel;
import dk.kea.projectplanner.models.PersonModel;
import dk.kea.projectplanner.models.UserModel;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapUtility {

    public static <P extends ActivityModel> Map<Long, P> listToMapActivity(List<P> list) {
        return list.stream().collect(Collectors.toMap(ActivityModel::getId, Function.identity()));
    }

    public static Map<Long, PersonModel> listToMapPerson(List<PersonModel> list) {
        return list.stream().collect(Collectors.toMap(PersonModel::getId, Function.identity()));
    }

    public static Map<Long, UserModel> listToMapUser(List<UserModel> list) {
        return list.stream().collect(Collectors.toMap(UserModel::getId, Function.identity()));

    }
}
