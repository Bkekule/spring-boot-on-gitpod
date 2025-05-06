package bobo_master_spring.gitpod_version.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bobo_master_spring.gitpod_version.demo.model.Person;

@Repository("postgress")
public class PersonDataAccessService implements PersonDao{
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertPerson'");
    }

    @Override
    public List<Person> selectAllPeople() {
        String sqlCommand = "SELECT id, name FROM person";
        return jdbcTemplate.query(sqlCommand, (personInfo, rowNumber) -> {
            UUID id = UUID.fromString(personInfo.getString("id"));
            String name = personInfo.getString("name");
            return new Person(id, name);
        });
    }
    // @Override
    // public List<Person> selectAllPeople() {
    //     return List.of(new Person(UUID.randomUUID(), "This is for PG"));
    // }

    @Override
    public int deletePersonbyId(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePersonbyId'");
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePersonById'");
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectPersonById'");
    }
    
}
