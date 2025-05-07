package bobo_master_spring.gitpod_version.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bobo_master_spring.gitpod_version.demo.model.Person;
import bobo_master_spring.gitpod_version.demo.service.PersonService;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.Valid;

@RequestMapping("test-endpoint")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @PostMapping
    public int addPerson(@Valid @NonNull @RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path="{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @PutMapping(path={"{id}"})
    public int updatePersonById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person){
        return personService.updatePersonById(id, person);
    }
}
