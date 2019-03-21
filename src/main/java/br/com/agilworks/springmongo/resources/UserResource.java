package br.com.agilworks.springmongo.resources;

import br.com.agilworks.springmongo.domain.User;
import br.com.agilworks.springmongo.dto.UserDTO;
import br.com.agilworks.springmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO()).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }
}
