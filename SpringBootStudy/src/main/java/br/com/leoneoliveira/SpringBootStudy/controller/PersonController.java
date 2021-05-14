package br.com.leoneoliveira.SpringBootStudy.controller;

import br.com.leoneoliveira.SpringBootStudy.data.model.Person;
import br.com.leoneoliveira.SpringBootStudy.data.vo.PersonVO;
import br.com.leoneoliveira.SpringBootStudy.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    public PersonController(PersonService services) {
        this.service = services;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<PersonVO> entityList = this.service.findAll();
        return new ResponseEntity<List>(entityList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        PersonVO entity = this.service.findById(id);
        return new ResponseEntity<PersonVO>(entity, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonVO PersonVO) {
        PersonVO entity = this.service.create(PersonVO);
        return new ResponseEntity<PersonVO>(entity, HttpStatus.CREATED);
    }

    @PutMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody PersonVO PersonVO) {
        PersonVO entity = this.service.update(PersonVO);
        return new ResponseEntity<PersonVO>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

}
