package br.com.agilworks.springmongo.resources;

import br.com.agilworks.springmongo.domain.Post;
import br.com.agilworks.springmongo.resources.util.URL;
import br.com.agilworks.springmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @GetMapping(value="/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
        text = URL.decodeParam(text);

        List<Post> list = postService.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }
}