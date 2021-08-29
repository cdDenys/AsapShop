package asapshop.service.Impl;

import asapshop.entity.User;
import asapshop.repository.UserRepository;
import asapshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        if (user != null){
            userRepository.save(user);
        }
    }
}
