package lucianosena.librarymongo.resources;

import lucianosena.librarymongo.domain.Book;
import lucianosena.librarymongo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BookService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> findAll() throws ParseException {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String data = "29/01/2005";
        Date dataFormated = formatoData.parse(data);
        List<Book> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
}
