package services;

import com.encryption.encryptionjpci.models.User;
import persist.Persist;
import static com.encryption.encryptionjpci.Encriptacion.decrypt;

public class AuthService {
    
    Persist persist = new Persist();

    public boolean authUser(String username, String password) {
    
        User user = persist.getUser(username);
        
        if (user == null) {
            return false;
        }
        
        String currentPassword = decrypt(user.getPassword());
        if (currentPassword != password) {
            return false;
        }
        return true;
        
    }

//    TODO: implement
//    public void logout(){}
}

