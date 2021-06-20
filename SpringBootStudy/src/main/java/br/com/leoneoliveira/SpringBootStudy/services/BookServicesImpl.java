package br.com.leoneoliveira.SpringBootStudy.services;

import br.com.leoneoliveira.SpringBootStudy.converter.DozerConverter;
import br.com.leoneoliveira.SpringBootStudy.data.model.Book;
import br.com.leoneoliveira.SpringBootStudy.data.model.Person;
import br.com.leoneoliveira.SpringBootStudy.data.vo.BookVO;
import br.com.leoneoliveira.SpringBootStudy.data.vo.PersonVO;
import br.com.leoneoliveira.SpringBootStudy.exception.ResourceNotFoundException;
import br.com.leoneoliveira.SpringBootStudy.repository.interfaces.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookServicesImpl implements BookService {

    @Autowired
    BookRepository repository;

    @Override
    public BookVO create(BookVO bookVO) {
        var entity = DozerConverter.parseObject(bookVO, Book.class);
        var entityVo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
        return entityVo;
    }

    @Override
    public BookVO update(BookVO bookVO) {
        return repository.findById(bookVO.getKey())
                .map(entity -> {
                    entity.setAuthor(bookVO.getAuthor());
                    entity.setLaunchDate(bookVO.getLaunchDate());
                    entity.setPrice(bookVO.getPrice());
                    entity.setTitle(bookVO.getTitle());
                    return DozerConverter.parseObject(repository.save(entity), BookVO.class);
                }).orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
    }

    @Override
    public void delete(Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
        repository.delete(book);
    }

    @Override
    public BookVO findById(Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
        return DozerConverter.parseObject(book, BookVO.class);
    }

    @Override
    public Page<BookVO> findAll(Pageable pageable) {
        var page = repository.findAll(pageable);
        return page.map(this::convertBookVO);
    }

    private BookVO convertBookVO(Book entity) {
        return DozerConverter.parseObject(entity, BookVO.class);
    }
}
