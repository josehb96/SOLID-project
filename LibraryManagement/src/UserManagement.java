import java.util.HashMap;
import java.util.Map;

interface UserManage{

    void registerUser(String userId, String name, int age, String email, String phoneNumber);
    void updateUser(String userId, String name, int age, String email, String phoneNumber);
    void deactivateUser(String userId);

}

public class UserManagement implements UserManage {
    
    private Map<String, User> users = new HashMap<>();

    @Override
    public void registerUser(String userId, String name, int age, String email, String phoneNumber){
        User user = new User(name, age, email, phoneNumber);
        users.put(userId, user);
    }

    @Override
    public void updateUser(String userId, String name, int age, String email, String phoneNumber){

        if (users.containsKey(userId)){
            
            User user = getUser(userId);
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);

        } else {
            System.out.println("User not found: " + userId);
        }

    }

    @Override
    public void deactivateUser(String userId){

        if (users.containsKey(userId)){
            users.remove(userId);
        } else {
            System.out.println("User not found: " + userId);
        }

    }

    // Additional methods for encapsulation
    public User getUser(String userId) {
        return users.get(userId);
    }

    public int getNumberOfUsers() {
        return users.size();
    }


}
