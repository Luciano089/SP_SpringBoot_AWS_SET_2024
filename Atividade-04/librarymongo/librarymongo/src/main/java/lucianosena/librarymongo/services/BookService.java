package lucianosena.librarymongo.services;

import lucianosena.librarymongo.domain.Book;
import lucianosena.librarymongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;
    public List<Book> findAll() {
        return repository.findAll();
    }
}
