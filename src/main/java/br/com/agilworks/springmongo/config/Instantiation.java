package br.com.agilworks.springmongo.config;

import br.com.agilworks.springmongo.domain.User;
import br.com.agilworks.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repo;

    @Override
    public void run(String... args) throws Exception {
        repo.deleteAll();

        repo.saveAll(Arrays.asList(
            new User(null, "Maria Brown", "maria@gmail.com"),
            new User(null, "Alex Green", "alex@gmail.com"),
            new User(null, "Bob Grey", "bob@gmail.com")
        ));
    }
}
