//package com.freq.auth;
//
//
//import com.freq.auth.model.post.Comment;
//import com.freq.auth.model.post.Post;
//import com.freq.auth.model.user.User;
//import com.freq.auth.payload.post.CommentRequest;
//import com.freq.auth.payload.post.response.comment.CommentResponse;
//import com.freq.auth.repository.UserRepository;
//import com.freq.auth.repository.post.CommentRepository;
//import com.freq.auth.repository.post.PostRepository;
//import com.freq.auth.security.UserPrincipal;
//import com.freq.auth.service.PostService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(true)
//public class TestPost {
//
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    PostRepository postRepository;
//    @Autowired
//    PostService postService;
////    @Autowired
////    UserPrincipal userPrincipal;
////    @Autowired
////    CommentRequest commentRequest;
//
//    @Autowired
//    CommentRepository commentRepository;
//
//    @Test
//    public void testFindbyId(){
//        Long id = Long.valueOf(1);
//        Optional<Post> post = postRepository.findById(Long.valueOf(1));
//        assertThat(post.get().getId()).isEqualTo(Long.valueOf(1));
//    }
//
//    @Test
//    public void testfindByCreatedBy(){
//        List<Post> post = postRepository.findByCreatedBy(Long.valueOf(1));
//        assertThat(post).isNotEmpty();
//    }
//
//    @Test
//    public void testGetAllPost(){
//        List<Post> post = postRepository.findAll();
//        assertThat(post).isNotEmpty();
//    }
//
////    @Test
////    public void testAddComment(){
////        Optional<User> user = userRepository.findById(Long.valueOf(1));
////        UserPrincipal userPrincipal1 = userPrincipal.create(user.get());
////        commentRequest.setBody("iu");
////        CommentResponse comment = postService.addComment(userPrincipal1,(long) 1, commentRequest);
////        List<Comment> comments = commentRepository.findCommentsByPostId((long) 1);
////        for(Comment comment1:comments)
////            if(comment1.getBody().equals("iu")) {
////        assertThat(comment.getBody()).isEqualTo("iu");
////    }
////}
//}
