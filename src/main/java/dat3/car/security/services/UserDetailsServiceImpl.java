package dat3.car.security.services;

import dat3.car.members.entities.Member;
import dat3.car.members.repositories.IMemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetailsServiceImpl(IMemberRepository userRepository, PasswordEncoder encoder) {
        _userRepository = userRepository;
        var admin = _userRepository.findByUsernameLike("MHAdmin").orElse(null);
        if(admin == null)
            createAdmin(encoder);
    }

    private void createAdmin(PasswordEncoder encoder)
    {
        var user = new Member();
        user.setUsername("MHAdmin");
        user.setPassword(encoder.encode("xrpuofni"));
        user.setRoles(new ArrayList<>(){{add("ADMIN");}});
        _userRepository.save(user);
    }

    private final IMemberRepository _userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        var user = _userRepository.findByUsernameLike(username).orElse(null);
        if (user == null)
            throw new UsernameNotFoundException("Could not find user");
        return new MyUserDetails(user);
    }
 
}