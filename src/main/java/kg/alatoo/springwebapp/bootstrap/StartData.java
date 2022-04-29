package kg.alatoo.springwebapp.bootstrap;

import kg.alatoo.springwebapp.config.MyBean;
import kg.alatoo.springwebapp.config.MyConfig;
import kg.alatoo.springwebapp.domain.Author;
import kg.alatoo.springwebapp.domain.Book;
import kg.alatoo.springwebapp.repositories.AuthorRepository;
import kg.alatoo.springwebapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component("startData")
public class StartData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final MyConfig myConfig;
    private final MyBean myBean;
    private final MyBean secondBean;

    public StartData(BookRepository bookRepository,
                     AuthorRepository authorRepository,
                     MyConfig myConfig,
                     @Qualifier("myBean") MyBean myBean,
                     @Qualifier("secondBean") MyBean secondBean) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.myConfig = myConfig;
        this.myBean = myBean;
        this.secondBean = secondBean;
    }

    @Override
    public void run(String... args) throws Exception {
        Book database = new Book("Database", "15345324");
        Author author = new Author("Islam","Aubakirov");
        Author author2 = new Author("Alina","Pinazarova");

        author.getBooks().add(database);
        author2.getBooks().add(database);

        database.getAuthors().add(author);
        database.getAuthors().add(author2);

        authorRepository.save(author);
        authorRepository.save(author2);
        bookRepository.save(database);

        System.out.println("myBean.getName() = " + myBean.getName());
        System.out.println("secondBean = " + secondBean.getName());

        /*MyBean myBean = mySecurityConfig.myBean();
        MyBean mySecondBean = mySecurityConfig.myBean();
        System.out.println("1:myBean.getName() = " + myBean.getName());
        System.out.println("1:mySecondBean.getName() = " + mySecondBean.getName());
        mySecondBean.setName("mySecondBean");
        System.out.println("2:myBean.getName() = " + myBean.getName());
        System.out.println("2:mySecondBean.getName() = " + mySecondBean.getName());*/


    }
}
