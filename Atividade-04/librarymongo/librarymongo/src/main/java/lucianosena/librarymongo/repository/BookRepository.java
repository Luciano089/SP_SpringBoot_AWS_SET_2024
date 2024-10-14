package lucianosena.librarymongo.repository;

import lucianosena.librarymongo.domain.Book;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findByName(String name);

    void deleteByName(String name);

    List<Book> findByAuthor(String author);

}
