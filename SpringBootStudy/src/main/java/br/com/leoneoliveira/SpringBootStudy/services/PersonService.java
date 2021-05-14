package br.com.leoneoliveira.SpringBootStudy.services;

import br.com.leoneoliveira.SpringBootStudy.data.model.Person;
import br.com.leoneoliveira.SpringBootStudy.data.vo.PersonVO;

import java.util.List;

public interface PersonService {

    public PersonVO create(PersonVO person);
    public PersonVO update(PersonVO person);
    public void delete(Long id);
    public PersonVO findById(Long id);
    public List<PersonVO> findAll();

}
