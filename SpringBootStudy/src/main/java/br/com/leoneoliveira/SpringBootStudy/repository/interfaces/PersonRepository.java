package br.com.leoneoliveira.SpringBootStudy.repository.interfaces;

import br.com.leoneoliveira.SpringBootStudy.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
