package persist;

import com.encryption.encryptionjpci.models.User;
import java.util.ArrayList;

public class Persist {
   public ArrayList<User> users;

    public Persist() {
        this.users = new ArrayList<>();
    }
   
   public void addUser (User user) {
       if(validateExistUser(user.getUsername())) {
           System.out.println("User exists");
           return;
       }
       users.add(user);
       System.out.println("Create user successfuly");
   }
   
   public User getUser(String username) {
       for(User user: users) {
           if(user.getUsername().equals(username)) {
               return user;
           }
       }
       System.out.println("User not found");
       return null;
   }
   
   public boolean validateExistUser(String username) {
       for(User user: users){
           if(user.getUsername().equals(username)) {
               return true;
           }
       }
       return false;
   }
}
