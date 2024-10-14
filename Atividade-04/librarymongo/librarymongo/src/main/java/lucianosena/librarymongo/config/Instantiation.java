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

        Book book1 = new Book("Senhor dos misterios", "Não sei", dataFormated, "Mystery", null);
        Book book2 = new Book("Declinio de um homem", "Osamu Dazai", dataFormated, "Mystery", null);
        bookRepository.saveAll(Arrays.asList(book1, book2));

    }
}
