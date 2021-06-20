package br.com.leoneoliveira.SpringBootStudy.services;

import br.com.leoneoliveira.SpringBootStudy.converter.DozerConverter;
import br.com.leoneoliveira.SpringBootStudy.data.model.Person;
import br.com.leoneoliveira.SpringBootStudy.data.vo.PersonVO;
import br.com.leoneoliveira.SpringBootStudy.exception.ResourceNotFoundException;
import br.com.leoneoliveira.SpringBootStudy.repository.interfaces.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonServicesImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    @Override
    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var entityVo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return entityVo;
    }

    @Override
    public PersonVO update(PersonVO person) {
        return repository.findById(person.getKey())
                .map(entity -> {
                    entity.setFirstName(person.getFirstName());
                    entity.setLastName(person.getLastName());
                    entity.setAddress(person.getAddress());
                    entity.setGender(person.getGender());
                    return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
                }).orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
    }

    @Override
    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
        repository.delete(entity);
    }

    @Override
    public PersonVO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    @Override
    public Page<PersonVO> findAll(Pageable pageable) {
        var page = repository.findAll(pageable);
        return page.map(this::convertPersonVO);
    }

    @Transactional
    @Override
    public PersonVO disablePerson(Long id) {
        repository.disablePersons(id);

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);

    }

    @Override
    public Page<PersonVO> findPersonByName(String firstName, Pageable pageable) {
        var page = repository.findPersonByName(firstName, pageable);
        return page.map(this::convertPersonVO);
    }

    private PersonVO convertPersonVO(Person entity) {
        return  DozerConverter.parseObject(entity, PersonVO.class);
    }
}
