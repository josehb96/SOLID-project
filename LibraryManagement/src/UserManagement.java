// import java.util.HashMap;
// import java.util.Map;

interface UserManage{

    void registerUser(LibraryData libraryData, String userId, String name, int age, String email, String phoneNumber);
    void updateUser(LibraryData libraryData, String userId, String name, int age, String email, String phoneNumber);
    void deactivateUser(LibraryData libraryData, String userId);

}

public class UserManagement implements UserManage {
    
    //private Map<String, User> users = new HashMap<>();

    @Override
    public void registerUser(LibraryData libraryData, String userId, String name, int age, String email, String phoneNumber){
        User user = new User(name, age, email, phoneNumber);
        libraryData.getUsers().put(userId, user);
    }

    @Override
    public void updateUser(LibraryData libraryData, String userId, String name, int age, String email, String phoneNumber){

        if (libraryData.getUsers().containsKey(userId)){
            
            User user = libraryData.getUsers().get(userId);
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);

        } else {
            System.out.println("User not found: " + userId);
        }

    }

    @Override
    public void deactivateUser(LibraryData libraryData, String userId){

        if (libraryData.getUsers().containsKey(userId)){
            libraryData.getUsers().remove(userId);
        } else {
            System.out.println("User not found: " + userId);
        }

    }

    // // Additional methods for encapsulation
    // public User getUser(String userId) {
    //     return users.get(userId);
    // }

    // public int getNumberOfUsers() {
    //     return users.size();
    // }

    // public Map<String, User> getUsers(){
    //     return users;
    // }


}
