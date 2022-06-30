//package com.freq.auth;
//
//
//import com.freq.auth.model.user.User;
//import com.freq.auth.repository.UserRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class TestUser {
//    @Autowired
//    private TestEntityManager testEntityManager;
//
//    @Autowired
//    private UserRepository userRepos;
//
//    @Test
//    public void testFindByUsernameOrEmail(){
//        String username = "Ninkuppj";
//        String email = "neulaanhhuy@gmail.com";
//        Optional<User> user = userRepos.findByUsernameOrEmail(username,email);
//
//        assertThat(user.get().getUsername()).isEqualTo("Ninkuppj") ;
//    }
//
//    @Test
//    public void testexistsByUsername(){
//        String username = "Quyền";
////        String email = "neulaanhhuy@gmail.com";
//        Optional<Boolean> user = Optional.ofNullable(userRepos.existsByUsername(username));
//
//        assertThat(user.get()).isTrue() ;
//    }
//    @Test
//    public void existsByEmail(){
////        String username = "Ninkuppj";
//        String email = "neulaanhhuy@gmail.com";
//        Optional<Boolean> user = Optional.ofNullable(userRepos.existsByEmail(email));
//
//        assertThat(user.get()).isFalse() ;
//    }
//}
//
