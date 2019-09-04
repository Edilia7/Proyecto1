package com.proyecto.proyecto.Repository;

import com.proyecto.proyecto.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}
