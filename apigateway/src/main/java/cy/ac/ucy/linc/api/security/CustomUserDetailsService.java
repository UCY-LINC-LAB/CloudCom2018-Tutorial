package cy.ac.ucy.linc.api.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private static List<UserObject> users = new ArrayList<>();


    public CustomUserDetailsService() {

//        users.add(new UserObject("user", "password", "ADMIN"));
        //Bcrypt for 'password'
        users.add(new UserObject("user", "$2a$04$/mGiTrKjvu4NU4bzBx.HQOh8PC6ktW0GZ9pMh0f5unfWgEkYfpB8.", "ADMIN"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<UserObject> user = users.stream().filter(u -> u.name.equals(s)).findAny();

        if (!user.isPresent()){
            throw new UsernameNotFoundException("Could not find user: "+s);
        }

        return toUserDetails(user.get());
    }

    private UserDetails toUserDetails(UserObject userObject){
        return User.withUsername(userObject.name).password(userObject.password).roles(userObject.role).build();
    }




    private static class UserObject {
        private String name;
        private String password;
        private String role;

        public UserObject(String name, String password, String role) {
            this.name = name;
            this.password = password;
            this.role = role;
        }
    }
}
