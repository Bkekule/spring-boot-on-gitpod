package bobo_master_spring.gitpod_version.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import bobo_master_spring.gitpod_version.demo.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.name()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonbyId(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person newPerson) {
        return selectPersonById(id).map(
            personMaybe -> {
                int indexOfPersonToUpdate = DB.indexOf(personMaybe);
                if (indexOfPersonToUpdate >= 0){
                    DB.set(indexOfPersonToUpdate, new Person(id, newPerson.name()));
                    return 1;
                }
                return 0;
            }
            ).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
        .filter(person->person.id().equals(id))
        .findFirst();
    }
    }
