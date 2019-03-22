package br.com.agilworks.springmongo.repository;

import br.com.agilworks.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // @Query methods
    List<Post> findByTitleContainingIgnoreCase(String text);
}
