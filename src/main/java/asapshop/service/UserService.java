package asapshop.service;

import asapshop.dto.UserRegistrationDTO;
import asapshop.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User createUser(UserRegistrationDTO registrationDto);

    User  getAuthorizedUser();
}
