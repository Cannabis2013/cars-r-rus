package dat3.car.services.security;

import dat3.car.entities.members.Member;
import dat3.car.entities.security.User;
import dat3.car.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetailsServiceImpl(MemberRepository userRepository, PasswordEncoder encoder) {
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
        user.setRole("ADMIN");
        _userRepository.save(user);
    }

    private MemberRepository _userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        var user = _userRepository.findByUsernameLike(username).orElse(null);
        if (user == null)
            throw new UsernameNotFoundException("Could not find user");
        return new MyUserDetails(user);
    }
 
}