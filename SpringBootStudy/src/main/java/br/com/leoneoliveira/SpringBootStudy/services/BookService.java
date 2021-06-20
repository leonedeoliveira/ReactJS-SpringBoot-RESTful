package br.com.leoneoliveira.SpringBootStudy.services;

import br.com.leoneoliveira.SpringBootStudy.data.vo.BookVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    public BookVO create(BookVO bookVO);

    public BookVO update(BookVO bookVO);

    public void delete(Long id);

    public BookVO findById(Long id);

    public Page<BookVO> findAll(Pageable pageable);
}
