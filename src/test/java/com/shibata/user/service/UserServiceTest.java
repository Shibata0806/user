package com.shibata.user.service;


import com.shibata.user.entity.User;
import com.shibata.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserMapper userMapper;

    @Test
    public void 存在するユーザーのIDを指定したときに正常にユーザーが返されること() {
        doReturn(Optional.of(new User(1, "yoshihito koyama", "koyama@example.com"))).when(userMapper).findById(1);
        User actual = userService.findUser(1);
        assertThat(actual).isEqualTo(new User(1, "yoshihito koyama", "koyama@example.com"));
        verify(userMapper).findById(1);
    }
}
