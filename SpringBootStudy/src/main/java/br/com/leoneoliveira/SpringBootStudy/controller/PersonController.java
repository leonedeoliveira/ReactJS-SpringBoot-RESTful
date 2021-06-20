package br.com.leoneoliveira.SpringBootStudy.controller;


import br.com.leoneoliveira.SpringBootStudy.data.vo.PersonVO;
import br.com.leoneoliveira.SpringBootStudy.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.domain.Sort.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Api(value = "Person EndPoint", description = "Description for Person", tags = {"PersonEndPoint"})
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private PagedResourcesAssembler<PersonVO> assembler;

    public PersonController(PersonService services) {
        this.service = services;
    }

    //@CrossOrigin(value = {"https://localhost:8080","https://www.leoneoliveira.com.br"})
    @ApiOperation(value = "Find all person record")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> getAllPerson(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "12") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection(direction), "firstName"));
        Page<PersonVO> entityList = this.service.findAll(pageable);
        entityList.stream()
                .forEach(x -> x.add(linkTo(methodOn(PersonController.class).getOnePerson(x.getKey())).withSelfRel()));

        return new ResponseEntity<>(assembler.toModel(entityList), HttpStatus.OK);
    }

    @ApiOperation(value = "Find person by name")
    @GetMapping(value = "/getPersonByName/{firstName}",produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> getPersonByName(
            @PathVariable(value = "firstName") String firstName,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "12") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection(direction), "firstName"));
        Page<PersonVO> entityList = this.service.findPersonByName(firstName, pageable);
        entityList.stream()
                .forEach(x -> x.add(linkTo(methodOn(PersonController.class).getOnePerson(x.getKey())).withSelfRel()));

        return new ResponseEntity<>(assembler.toModel(entityList), HttpStatus.OK);
    }

    @ApiOperation(value = "Find by id person record")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> getOnePerson(@PathVariable("id") Long id) {
        PersonVO entity = this.service.findById(id);
        entity.add(linkTo(methodOn(PersonController.class).getOnePerson(id)).withSelfRel());
        return new ResponseEntity<PersonVO>(entity, HttpStatus.OK);
    }

    @ApiOperation(value = "Disable a specific person by your ID")
    @PatchMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> disablePerson(@PathVariable("id") Long id) {
        PersonVO entity = this.service.disablePerson(id);
        entity.add(linkTo(methodOn(PersonController.class).getOnePerson(id)).withSelfRel());
        return new ResponseEntity<PersonVO>(entity, HttpStatus.OK);
    }

    @ApiOperation(value = "Create Person")
    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> createPerson(@RequestBody PersonVO PersonVO) {
        PersonVO entity = this.service.create(PersonVO);
        entity.add(linkTo(methodOn(PersonController.class).getOnePerson(PersonVO.getKey())).withSelfRel());
        return new ResponseEntity<PersonVO>(entity, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Person")
    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> updatePerson(@RequestBody PersonVO PersonVO) {
        PersonVO entity = this.service.update(PersonVO);
        entity.add(linkTo(methodOn(PersonController.class).getOnePerson(PersonVO.getKey())).withSelfRel());
        return new ResponseEntity<PersonVO>(entity, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete person by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    private Direction sortDirection(String direction) {
        return "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
    }

}
