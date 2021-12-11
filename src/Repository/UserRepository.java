package Repository;

import Model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    static Map<String, User> userRepo=new HashMap<>();

    public static void save(User user)
    {
        userRepo.put(user.getUserId(),user);
    }

    public static boolean isExist(String userId)
    {
        if(userRepo.containsKey(userId))
            return true;
        return false;
    }
    public static User getUser(String userId)
    {
        if(userRepo.containsKey(userId))
            return userRepo.get(userId);
        return null;
    }
}
