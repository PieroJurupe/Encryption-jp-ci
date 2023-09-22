
package services;

import com.encryption.encryptionjpci.models.User;
import persist.Persist;
import static com.encryption.encryptionjpci.Encriptacion.encrypt;
import static com.encryption.encryptionjpci.Encriptacion.decrypt;


public class ResetPasswordService {
     Persist persist = new Persist();
     
    public boolean changePassword(String username, String newPassword) {
           
        User user = persist.getUser(username);
        
        if (user == null) {
            return false;
        }
        
        user.setPassword(encrypt(newPassword));
        return true;
    }

    public boolean validateCurrentPassword(String username, String currentPassword) {
    
        User user = persist.getUser(username);
        
        if(user == null) {
            return false;
        }
        
        String currPassword = decrypt(user.getPassword());
        
        if (currPassword != currentPassword) {
            return false;
        }
        return true;
    }
    
}
