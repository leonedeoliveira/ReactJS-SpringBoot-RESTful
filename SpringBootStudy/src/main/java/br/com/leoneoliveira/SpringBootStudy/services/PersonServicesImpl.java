package br.com.leoneoliveira.SpringBootStudy.services;

import br.com.leoneoliveira.SpringBootStudy.converter.DozerConverter;
import br.com.leoneoliveira.SpringBootStudy.data.model.Person;
import br.com.leoneoliveira.SpringBootStudy.data.vo.PersonVO;
import br.com.leoneoliveira.SpringBootStudy.exception.ResourceNotFoundException;
import br.com.leoneoliveira.SpringBootStudy.repository.interfaces.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServicesImpl implements PersonService{

    @Autowired
    PersonRepository repository;

    public PersonServicesImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var entityVo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return entityVo;
    }

    @Override
    public PersonVO update(PersonVO person) {
        return repository.findById(person.getId())
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
    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }
}
