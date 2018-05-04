package com.doodle.web.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * @author 周云龙
 * @date 2018/5/3 15:11
 */
@Component
public interface UserRepository extends JpaRepository<User,Long> {


    /**
     *
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 它们分别实现了按name查询User实体和按name和age查询User实体，可以看到我们这里没有任何类SQL语句就完成了两个条件查询方法。
     * 这就是Spring-data-jpa的一大特性：通过解析方法名创建查询。
     * @param name
     * @param age
     * @return
     */
    User findByNameAndAge(String name, Integer age);

    /**
     * 除了通过解析方法名来创建查询外，它也提供通过使用@Query 注解来创建查询，您只需要编写JPQL语句，
     * 并通过类似“:name”来映射@Param指定的参数，就像例子中的第三个findUser函数一样。
     * @param name
     * @return
     */
    @Query(value = "SELECT * FROM user u WHERE name=:name", nativeQuery = true)
    User findUser(@Param("name") String name);
}
