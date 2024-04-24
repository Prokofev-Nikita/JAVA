package by.bsuir.prokofyev.binanceproject.controller;
import by.bsuir.prokofyev.binanceproject.api.controller.UserController;
import by.bsuir.prokofyev.binanceproject.cache.EntityCache;
import by.bsuir.prokofyev.binanceproject.entity.User;
import by.bsuir.prokofyev.binanceproject.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EntityCache<User> userCache;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        Optional<User> userOptional = Optional.of(user);

        Mockito.when(userRepository.findById(userId)).thenReturn(userOptional);
        Mockito.when(userCache.get(userId)).thenReturn(Optional.empty());

        ResponseEntity<User> response = userController.getUserById(userId);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(user, response.getBody());

        Mockito.verify(userCache).put(userId, user);
    }

    @Test
    public void testGetUserByIdNotFound() {
        Long userId = 1L;
        Optional<User> userOptional = Optional.empty();

        Mockito.when(userRepository.findById(userId)).thenReturn(userOptional);
        Mockito.when(userCache.get(userId)).thenReturn(Optional.empty());

        ResponseEntity<User> response = userController.getUserById(userId);

        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assert.assertNull(response.getBody());
    }

    @Test
    public void testBulkUpdateUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());

        ResponseEntity<String> response = userController.bulkUpdateUsers(users);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Bulk operation completed successfully", response.getBody());

        Mockito.verify(userRepository).saveAll(users);
    }
}