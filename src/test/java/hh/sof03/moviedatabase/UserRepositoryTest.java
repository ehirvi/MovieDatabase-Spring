package hh.sof03.moviedatabase;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.moviedatabase.domain.User;
import hh.sof03.moviedatabase.domain.UserRepository;

@DataJpaTest
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createNewUser() {
        User user = new User("testUser", "erdpgjeg0943905h0ifdg", "USER");
        userRepository.save(user);
        Assertions.assertThat(user.getId()).isNotNull();
    }

}
