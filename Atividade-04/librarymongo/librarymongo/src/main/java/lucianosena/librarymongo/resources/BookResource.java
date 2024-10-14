package lucianosena.librarymongo.resources;

import lucianosena.librarymongo.domain.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="books")
public class BookResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> findAll() throws ParseException {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String data = "29/01/2005";
        Date dataFormated = formatoData.parse(data);
        Book book = new Book("Não sei", "Ladrão de raios", dataFormated, "Fantasy", null);
        List<Book> listBook = new ArrayList<>();
        listBook.addAll(Arrays.asList(book));
        return ResponseEntity.ok().body(listBook);

    }
}
