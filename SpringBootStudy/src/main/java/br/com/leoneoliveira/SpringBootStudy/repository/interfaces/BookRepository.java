package br.com.leoneoliveira.SpringBootStudy.repository.interfaces;

import br.com.leoneoliveira.SpringBootStudy.data.model.Book;
import br.com.leoneoliveira.SpringBootStudy.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
