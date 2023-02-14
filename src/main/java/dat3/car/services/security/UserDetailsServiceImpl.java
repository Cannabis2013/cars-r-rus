package dat3.car.services.security;

import dat3.car.Entities.security.User;
import dat3.car.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        _userRepository = userRepository;
        var admin = _userRepository.findByUsernameLike("MHAdmin").orElse(null);
        if(admin == null)
            createAdmin(encoder);
    }

    private void createAdmin(PasswordEncoder encoder)
    {
        var user = new User();
        user.setUsername("MHAdmin");
        user.setPassword(encoder.encode("xrpuofni"));
        user.setRole("ADMIN");
        _userRepository.save(user);
    }

    private UserRepository _userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        var user = _userRepository.getUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Could not find user");
        return new MyUserDetails(user);
    }
 
}