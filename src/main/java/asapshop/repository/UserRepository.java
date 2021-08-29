package asapshop.repository;

import asapshop.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User getUserByLogin(String login);
}
