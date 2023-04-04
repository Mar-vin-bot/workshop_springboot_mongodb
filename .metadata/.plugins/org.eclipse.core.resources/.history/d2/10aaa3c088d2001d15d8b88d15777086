package com.marvinsilva.workshop.config;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marvinsilva.workshop.dto.AuthorDTO;
import com.marvinsilva.workshop.dto.CommentDTO;
import com.marvinsilva.workshop.entities.Post;
import com.marvinsilva.workshop.entities.User;
import com.marvinsilva.workshop.repository.PostRepository;
import com.marvinsilva.workshop.repository.UserRepository;

@Configuration
public class Instance implements CommandLineRunner{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("27/04/1991"), "Partiu viagem ", "Vou viajar para SP", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("24/11/1987"), "Oasis ", "Wonderwall", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("olá sou o primeiro commentario c1", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("olá sou o comentatio c2", sdf.parse("17/04/2018"), new AuthorDTO(maria));
		CommentDTO c3 = new CommentDTO("sou o comentatio c3", sdf.parse("12/04/2018"), new AuthorDTO(alex));
		
		post1.getComment().addAll(Arrays.asList(c1, c2));
		post2.getComment().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		repository.save(maria);
		
	}

}
