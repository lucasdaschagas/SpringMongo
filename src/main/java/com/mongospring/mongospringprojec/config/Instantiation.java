package com.mongospring.mongospringprojec.config;

import com.mongospring.mongospringprojec.domain.Post;
import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.dto.AuthorDTO;
import com.mongospring.mongospringprojec.repository.PostRepository;
import com.mongospring.mongospringprojec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User("1","Maria Brown", "mariabrown@gmail.com");
        User bob = new User("2","Bob Green", "bobgreen@gmail.com");
        User mark = new User("3","Mark Blue", "markblue@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,bob,mark));

        Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem",
                "Vou viajar para São Paulo, abraços",new AuthorDTO(maria));

        Post post2 = new Post(null,sdf.parse("25/03/2019"),"Voltando da viagem",
                "Vou voltar para casa, adeus",new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1,post2));





    }

}
