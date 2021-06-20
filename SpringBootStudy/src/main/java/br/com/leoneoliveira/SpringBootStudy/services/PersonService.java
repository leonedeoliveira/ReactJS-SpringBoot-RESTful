package br.com.leoneoliveira.SpringBootStudy.services;

import br.com.leoneoliveira.SpringBootStudy.data.vo.PersonVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    public PersonVO create(PersonVO personVO);

    public PersonVO update(PersonVO personVO);

    public void delete(Long id);

    public PersonVO findById(Long id);

    public Page<PersonVO> findAll(Pageable pageable);

    public PersonVO disablePerson(Long id);

    public Page<PersonVO> findPersonByName(String firstName, Pageable pageable);

}
