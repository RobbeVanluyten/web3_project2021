package domain.db;

import domain.model.DomainException;
import domain.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDbInMemory {
    private List<Person> personsInMemory;

    public PersonDbInMemory(){
        personsInMemory = new ArrayList<>();
    }
    public Person get(String personId) {
        for (Person person : personsInMemory) {
            if (person.getUserid().equals(personId))
                return person;
        }
        throw new DomainException("De persoon met persoonId'" + personId + "' kan niet gevonden worden");
    }

    public List<Person> getAll() {
        return personsInMemory;
    }

    public void add(Person person) {
        if(person == null){
            throw new DomainException("Persoon dat je wilt toevoegen bestaat niet");
        }
        personsInMemory.add(person);
    }

    public void update(Person person) {
        if(person == null){
            throw new DomainException("Persoon dat je wilt toevoegen bestaat niet");
        }
        for (Person person1 : personsInMemory) {
            if (person1.equals(person)){
                personsInMemory.set(personsInMemory.indexOf(person1), person);
            }
        }
    }

    public void delete(String id) {
        for (Person person : personsInMemory) {
            if (person.getUserid().equals(id))
                personsInMemory.remove(person);
        }
        throw new DomainException("De persoon met persoonId'" + id + "' kan niet gevonden worden");
    }
}
