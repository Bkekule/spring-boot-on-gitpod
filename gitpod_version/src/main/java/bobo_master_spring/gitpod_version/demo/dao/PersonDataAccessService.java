package bobo_master_spring.gitpod_version.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import bobo_master_spring.gitpod_version.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{
    
    private final JdbcTemplate jdbcTemplate;

    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        String sqlCommand = "INSERT INTO person (id, name) VALUE (?, ?)";
        return jdbcTemplate.update(sqlCommand, id, person.getName());
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

    @Override
    public int deletePersonbyId(UUID id) {
        String sqlCommand = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sqlCommand, id);
    }

    @Override
    public int updatePersonById(UUID id, @NonNull Person person) {
        String sqlCommand = "UPDATE person SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sqlCommand, person.getName(), id);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        String sqlCommand = "SELECT id, name FROM person WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                sqlCommand,
                (resultSet, rowNumber) -> {
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String personName = resultSet.getString("name");
                    return new Person(personId, personName);
                },
                id
        ));
    }
    
}
