package com.doodle.web.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#project
 *
 * @author 周云龙
 * @date 2018/5/4 9:48
 */
@Component
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * 3.2.2 Declare query methods on the interface.
     *
     * @param lastName
     * @return
     */
    List<Person> findByLastName(String lastName);

}
