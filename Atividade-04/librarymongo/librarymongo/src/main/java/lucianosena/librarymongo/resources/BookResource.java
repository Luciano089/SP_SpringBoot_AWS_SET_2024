package lucianosena.librarymongo.resources;

import lucianosena.librarymongo.domain.Book;
import lucianosena.librarymongo.repository.BookRepository;
import lucianosena.librarymongo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="books")
public class BookResource {

    @Autowired
    private BookService service;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() throws ParseException {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String data = "29/01/2005";
        Date dataFormated = formatoData.parse(data);
        List<Book> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Book> Insert(@RequestBody Book book)  {
        Book newBook = service.insert(book);
        return ResponseEntity.ok().body(newBook);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Book> Delete(@PathVariable String name)  {
        service.deleteByName(name);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{name}/publication-date")
    public ResponseEntity<Void> updatePublicationDate(@PathVariable String name, @RequestBody Date newPublicationDate) {
        service.updatePublicationYear(name, newPublicationDate);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-{author}")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable String author) {
        List<Book> books = service.findByAuthor(author);
        return ResponseEntity.ok(books);
    }


}
