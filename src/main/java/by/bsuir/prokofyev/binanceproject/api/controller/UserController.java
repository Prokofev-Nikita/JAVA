package by.bsuir.prokofyev.binanceproject.api.controller;

import by.bsuir.prokofyev.binanceproject.repository.UserRepository;
import by.bsuir.prokofyev.binanceproject.cache.EntityCache;
import by.bsuir.prokofyev.binanceproject.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final EntityCache<User> userCache;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        if (userCache.get(id).isEmpty()) userRepository.findById(id).ifPresent(user -> userCache.put(id, user));
        return userCache.get(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}