package lucianosena.librarymongo.services;

import lucianosena.librarymongo.domain.Book;
import lucianosena.librarymongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;
;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book insert(Book book) {
        return repository.insert(book);
    }

    public Optional<Book> findByName(String name) {
        return repository.findByName(name);
    }

    public void deleteByName(String name) {
        Optional<Book> bookOptional = repository.findByName(name);
        bookOptional.ifPresent(book -> repository.deleteByName(book.getName()));
    }

    public void updatePublicationYear(String name, Date newPublicationDate) {
        Optional<Book> bookOptional = repository.findByName(name);
        bookOptional.ifPresent(book -> {
            book.setPublicationDate(newPublicationDate);
            repository.save(book);
        });
    }

    public List<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }


}
