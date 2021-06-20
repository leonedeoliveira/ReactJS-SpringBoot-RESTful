package br.com.leoneoliveira.SpringBootStudy.mocks;

import br.com.leoneoliveira.SpringBootStudy.data.model.Book;
import br.com.leoneoliveira.SpringBootStudy.data.vo.BookVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookVO mockVO() {
        return mockVO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> bookVOList = new ArrayList<BookVO>();
        for (int i = 0; i < 14; i++) {
            bookVOList.add(mockVO(i));
        }
        return bookVOList;
    }

    private Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(number.longValue());
        book.setTitle("Title teste" + number);
        book.setPrice(25.30);
        book.setAuthor("Author test" + number);
        book.setLaunchDate(new Date());
        return book;
    }

    private BookVO mockVO(Integer number) {
        BookVO bookVO = new BookVO();
        bookVO.setKey(number.longValue());
        bookVO.setTitle("Title teste" + number);
        bookVO.setPrice(25.30);
        bookVO.setAuthor("Author test" + number);
        bookVO.setLaunchDate(new Date());
        return bookVO;
    }
}
