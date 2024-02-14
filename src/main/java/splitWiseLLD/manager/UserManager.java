package splitWiseLLD.manager;

import splitWiseLLD.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> userMap;

    public UserManager() {
        this.userMap = new HashMap<>();
    }

    public User getUser(String userId) {
        return userMap.get(userId);
    }

    public void createUser(String userId) {
        User user = User.builder()
                .userId(userId)
                .expenses(new ArrayList<>())
                .build();

        userMap.put(userId, user);
    }
}
