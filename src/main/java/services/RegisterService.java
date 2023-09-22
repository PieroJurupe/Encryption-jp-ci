package services;
import static com.encryption.encryptionjpci.Encriptacion.encrypt;
import com.encryption.encryptionjpci.models.User;
import persist.Persist;
import userInterfaces.MainScreen;

public class RegisterService {
    
    MainScreen mainScreen = new MainScreen();
    
    public boolean registerUser(User user) {
        Persist persist = new Persist();
        user.setPassword(generatePassword(user.getPassword()));
        persist.addUser(user);
        mainScreen.loadUsers();
        return true;
    }

    private String generatePassword (String password) {
        return encrypt(password);
    }
}
