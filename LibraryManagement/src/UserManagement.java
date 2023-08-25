// import java.util.HashMap;
// import java.util.Map;

import java.util.Map;

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
        System.out.println("User registered correctly.");
    }

    @Override
    public void updateUser(LibraryData libraryData, String userId, String name, int age, String email, String phoneNumber){

        if (libraryData.getUsers().containsKey(userId)){
            
            User user = libraryData.getUsers().get(userId);
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            System.out.println("User updated correctly.");

        } else {
            System.out.println("User not found: " + userId);
        }

    }

    @Override
    public void deactivateUser(LibraryData libraryData, String userId){

        if (libraryData.getUsers().containsKey(userId)){
            libraryData.getUsers().remove(userId);
            System.out.println("User deactivated correctly.");
        } else {
            System.out.println("User not found: " + userId);
        }

    }

    public void generateRegisteredUsersReport(LibraryData libraryData) {

        System.out.println();
        System.out.println("Registered Users:");

        for (Map.Entry<String, User> entry : libraryData.getUsers().entrySet()) {
            System.out.println("- " + entry.getKey() + " | " + entry.getValue().getName() + " | " + entry.getValue().getAge() + " | " + entry.getValue().getEmail() + " | " + entry.getValue().getPhoneNumber());
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
