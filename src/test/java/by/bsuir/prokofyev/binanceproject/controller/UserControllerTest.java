package by.bsuir.prokofyev.binanceproject.controller;
import by.bsuir.prokofyev.binanceproject.cache.EntityCache;
import by.bsuir.prokofyev.binanceproject.entity.User;
import by.bsuir.prokofyev.binanceproject.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EntityCache<User> userCache;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserByIdExistsInCache() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        Mockito.when(userCache.get(userId)).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userController.getUserById(userId);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(user, response.getBody());

        Mockito.verify(userRepository, Mockito.never()).findById(Mockito.anyLong());
        Mockito.verify(userCache, Mockito.never()).put(Mockito.anyLong(), Mockito.any(User.class));
    }

    @Test
    public void testGetUserByIdExistsInRepository() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        Optional<User> userOptional = Optional.of(user);

        Mockito.when(userCache.get(userId)).thenReturn(Optional.empty());
        Mockito.when(userRepository.findById(userId)).thenReturn(userOptional);
        Mockito.doNothing().when(userCache).put(userId, user);

        ResponseEntity<User> response = userController.getUserById(userId);

        //Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        //Assertions.assertEquals(user, response.getBody());

        Mockito.verify(userRepository).findById(userId);
        Mockito.verify(userCache).put(userId, user);
    }

    @Test
    public void testGetUserByIdNotFound() {
        Long userId = 1L;

        Mockito.when(userCache.get(userId)).thenReturn(Optional.empty());
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());

        ResponseEntity<User> response = userController.getUserById(userId);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(response.getBody());

        Mockito.verify(userRepository).findById(userId);
        Mockito.verify(userCache, Mockito.never()).put(Mockito.anyLong(), Mockito.any(User.class));
    }
    
    @Test
    public void testBulkUpdateUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());

        ResponseEntity<String> response = userController.bulkUpdateUsers(users);

        Mockito.verify(userRepository).saveAll(users);
    }
}