package com.doodle.web.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周云龙
 * @date 2018/5/4 10:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserRepositoryApplication.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSave(){
        Address address = new Address("463901","洛阳","香樟大道");
        Person person = new Person("镜华","天马",address);
        List<Person> list = new ArrayList<>();
        list.add(person);
        personRepository.saveAll(list);
    }

    @Test
    public void testFind(){
        List<Person> personList = personRepository.findByLastName("天马");
        personList.forEach(System.out::println);
    }

}
