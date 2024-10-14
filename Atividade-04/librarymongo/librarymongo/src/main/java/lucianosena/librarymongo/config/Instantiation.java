package lucianosena.librarymongo.config;

import lucianosena.librarymongo.domain.Book;
import lucianosena.librarymongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String data = "29/01/2005";
        Date dataFormated = formatoData.parse(data);

        Book book1 = new Book("1984", "George Orwell", formatoData.parse("08/06/1949"), "Ficção Científica", null);
        Book book2 = new Book("Dom Casmurro", "Machado de Assis", formatoData.parse("01/01/1899"), "Romance", null);
        Book book3 = new Book("The Lord of the Rings", "J.R.R. Tolkien", formatoData.parse("29/07/1954"), "Fantasia", null);
        Book book4 = new Book("Animal Farm", "George Orwell", formatoData.parse("17/08/1945"), "Fábula", null);
        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));

    }
}
