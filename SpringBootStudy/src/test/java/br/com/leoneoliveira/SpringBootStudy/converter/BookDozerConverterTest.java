package br.com.leoneoliveira.SpringBootStudy.converter;

import br.com.leoneoliveira.SpringBootStudy.data.model.Book;
import br.com.leoneoliveira.SpringBootStudy.data.vo.BookVO;
import br.com.leoneoliveira.SpringBootStudy.mocks.MockBook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookDozerConverterTest {

    MockBook inputObject;

    @Before
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerConverter.parseObject(inputObject.mockEntity(), BookVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("Title teste0", output.getTitle());
        Assert.assertEquals(25.30, 25.30, output.getPrice());
        Assert.assertEquals("Author test0", output.getAuthor());
        Assert.assertEquals("Author test0", output.getAuthor());
        //Assert.assertEquals(new Date(), output.getAuthor());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), BookVO.class);
        BookVO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("Title teste0", outputZero.getTitle());
        Assert.assertEquals(25.30, 25.30, outputZero.getPrice());
        Assert.assertEquals("Author test0", outputZero.getAuthor());
        Assert.assertEquals("Author test0", outputZero.getAuthor());
        //Assert.assertEquals(new Date(), outputZero.getAuthor());

        BookVO outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("Title teste7", outputSeven.getTitle());
        Assert.assertEquals(25.30, 25.30, outputSeven.getPrice());
        Assert.assertEquals("Author test7", outputSeven.getAuthor());
        Assert.assertEquals("Author test7", outputSeven.getAuthor());
        //Assert.assertEquals(new Date(), outputSeven.getAuthor());

        BookVO outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("Title teste12", outputTwelve.getTitle());
        Assert.assertEquals(25.30, 25.30, outputTwelve.getPrice());
        Assert.assertEquals("Author test12", outputTwelve.getAuthor());
        Assert.assertEquals("Author test12", outputTwelve.getAuthor());
        //Assert.assertEquals(new Date(), outputTwelve.getAuthor());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = DozerConverter.parseObject(inputObject.mockVO(), Book.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Title teste0", output.getTitle());
        Assert.assertEquals(25.30, 25.30, output.getPrice());
        Assert.assertEquals("Author test0", output.getAuthor());
        Assert.assertEquals("Author test0", output.getAuthor());
        //Assert.assertEquals(new Date(), output.getAuthor());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), Book.class);
        Book outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Title teste0", outputZero.getTitle());
        Assert.assertEquals(25.30, 25.30, outputZero.getPrice());
        Assert.assertEquals("Author test0", outputZero.getAuthor());
        Assert.assertEquals("Author test0", outputZero.getAuthor());
        //Assert.assertEquals(new Date(), outputZero.getAuthor());

        Book outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Title teste7", outputSeven.getTitle());
        Assert.assertEquals(25.30, 25.30, outputSeven.getPrice());
        Assert.assertEquals("Author test7", outputSeven.getAuthor());
        Assert.assertEquals("Author test7", outputSeven.getAuthor());
        //Assert.assertEquals(new Date(), outputSeven.getAuthor());

        Book outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Title teste12", outputTwelve.getTitle());
        Assert.assertEquals(25.30, 25.30, outputTwelve.getPrice());
        Assert.assertEquals("Author test12", outputTwelve.getAuthor());
        Assert.assertEquals("Author test12", outputTwelve.getAuthor());
        //Assert.assertEquals(new Date(), outputTwelve.getAuthor());
    }
}
