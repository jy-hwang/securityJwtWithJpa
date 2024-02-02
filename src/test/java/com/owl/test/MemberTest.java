package com.owl.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.owl.test.api.members.dto.RequestJoin;
import com.owl.test.models.member.MemberJoinService;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class MemberTest {

    @Autowired
    private MemberJoinService joinService;

    @Test
    public void insertData() {
        RequestJoin form =
                new RequestJoin(
                        "user01@test.org",
                        "12345678",
                        "12345678",
                        "사용자01",
                        "01010001000",
                        true);
        joinService.save(form);
    }
}