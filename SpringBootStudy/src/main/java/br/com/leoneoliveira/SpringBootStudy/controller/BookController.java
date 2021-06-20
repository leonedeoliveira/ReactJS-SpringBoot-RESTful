package br.com.leoneoliveira.SpringBootStudy.controller;

import br.com.leoneoliveira.SpringBootStudy.data.vo.BookVO;
import br.com.leoneoliveira.SpringBootStudy.data.vo.PersonVO;
import br.com.leoneoliveira.SpringBootStudy.services.BookService;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Api(value = "Book EndPoint", description = "Description for Book", tags = {"BookEndPoint"})
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService service;

    @Autowired
    private PagedResourcesAssembler<BookVO> assembler;

    public BookController(BookService service) {
        this.service = service;
    }


    @ApiOperation(value = "Find by ID books record")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> getOneBook(@PathVariable("id") Long id) {
        BookVO entity = this.service.findById(id);
        entity.add(linkTo(methodOn(BookController.class).getOneBook(id)).withSelfRel());
        return new ResponseEntity<BookVO>(entity, HttpStatus.OK);
    }

    @ApiOperation(value = "Find all books record")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> getAllBooks(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "5") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection(direction), "title"));

        Page<BookVO> entityList = this.service.findAll(pageable);
        entityList.stream()
                .forEach(x -> x.add(linkTo(methodOn(BookController.class).getOneBook(x.getKey())).withSelfRel()));

        return new ResponseEntity<>(assembler.toModel(entityList), HttpStatus.OK);
    }

    @ApiOperation(value = "Create book")
    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> createPerson(@RequestBody BookVO bookVO) {
        BookVO entity = this.service.create(bookVO);
        entity.add(linkTo(methodOn(BookController.class).getOneBook(bookVO.getKey())).withSelfRel());
        return new ResponseEntity<BookVO>(entity, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update book")
    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> updatePerson(@RequestBody BookVO bookVO) {
        BookVO entity = this.service.update(bookVO);
        entity.add(linkTo(methodOn(BookController.class).getOneBook(bookVO.getKey())).withSelfRel());
        return new ResponseEntity<BookVO>(entity, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete book by AI")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    private Sort.Direction sortDirection(String direction) {
        return "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
    }
}
