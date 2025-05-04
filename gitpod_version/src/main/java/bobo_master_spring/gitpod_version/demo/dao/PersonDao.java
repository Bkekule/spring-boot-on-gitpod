package bobo_master_spring.gitpod_version.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import bobo_master_spring.gitpod_version.demo.model.Person;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    int deletePersonbyId(UUID id);

    int updatePersonById(UUID id, Person person);

    Optional<Person> selectPersonById(UUID id);
}
