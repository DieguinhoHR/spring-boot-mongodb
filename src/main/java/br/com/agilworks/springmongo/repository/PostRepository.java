package br.com.agilworks.springmongo.repository;

import br.com.agilworks.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // @Query
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") // i pra ignorar maiúsculas e minúsculas
    List<Post> searchTitle(String search);
    // @Query methods
    List<Post> findByTitleContainingIgnoreCase(String text);
}
