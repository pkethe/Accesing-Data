package com.exampleaql.accesingdatamysql;

import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User,Integer> {
}
