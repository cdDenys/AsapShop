package asapshop.service.Impl;

import asapshop.dto.UserRegistrationDTO;
import asapshop.entity.Role;
import asapshop.entity.User;
import asapshop.repository.UserRepository;
import asapshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(UserRegistrationDTO registrationDto) {
        User user = new User(registrationDto.getName(),
                registrationDto.getSurname(), registrationDto.getLogin(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("USER")));

        return userRepository.save(user);
    }

    @Override
    public User getAuthorizedUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.getUserByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userRepository.getUserByLogin(login);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
