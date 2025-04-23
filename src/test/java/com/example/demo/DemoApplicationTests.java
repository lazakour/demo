package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;


@Import(TestcontainersConfiguration.class)
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
    @Autowired
    MyRepository repository;

    @BeforeEach
    void setUp() {

        repository.deleteAll();
        repository.save(new MyEntity("x4", "Belgium", "UK", "Ireland"));
    }

    @Test
    void shouldGetPendingMyEntitys() {
		MyEntity x4 = repository.findByBusinessKeyQuery("x4").get();
		assertThat(x4.getBusinessKey()).isEqualTo("x4");
    }

}
