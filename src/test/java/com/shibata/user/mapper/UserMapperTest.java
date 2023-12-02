package com.shibata.user.mapper;


import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.shibata.user.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    @DataSet(value = "datasets/users.yml")
    @Transactional
    void すべてのユーザーが取得できること() {
        List<User> users = userMapper.findAll();
        assertThat(users)
                .hasSize(3)
                .contains(
                        new User(1, "清⽔", "shimizu@example.com"),
                        new User(2, "⼩⼭", "koyama@example.com"),
                        new User(3, "⽥中", "tanaka@example.com")
                );
    }
}
