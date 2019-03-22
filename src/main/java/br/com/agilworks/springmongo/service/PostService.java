package br.com.agilworks.springmongo.service;

import br.com.agilworks.springmongo.domain.Post;
import br.com.agilworks.springmongo.domain.User;
import br.com.agilworks.springmongo.repository.PostRepository;
import br.com.agilworks.springmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
