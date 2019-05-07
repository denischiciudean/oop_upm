import java.util.Random;
import java.util.Vector;

import pages.*;

class BookWriter extends Book {

    private static Integer defaultBookNumbers = 5;


    private static Vector<String> names = new Vector<>();
    private static Vector<String> authors = new Vector<>();
    private static Vector<String> pagesContent = new Vector<>();


    BookWriter(Integer _n) {

        defaultBookNumbers = _n;

        //TODO:Implement File reading

        names.addElement("The 10X Rule");
        names.addElement("A Short Guide to a Happy Life");
        names.addElement("10% Happier");
        names.addElement("Adapt");
        names.addElement("How to pass");

        authors.addElement("Grant Cardone");
        authors.addElement("Anna Quindlen");
        authors.addElement("Dan Harris");
        authors.addElement("Tim Harford");
        authors.addElement("Denis Chiciudean");

        pagesContent.addElement("The Book in Three Sentences: Practicing meditation and mindfulness will make you at least 10 percent happier. Being mindful doesn’t change the problems in your life, but mindfulness does help you respond to your problems rather than react to them. Mindfulness helps you realize that striving for success is fine as long as you accept that the outcome is outside your control.");
        pagesContent.addElement("The Book in Three Sentences: The 10X Rule says that 1) you should set targets for yourself that are 10X greater than what you believe you can achieve and 2) you should take actions that are 10X greater than what you believe are necessary to achieve your goals. The biggest mistake most people make in life is not setting goals high enough. Taking massive action is the only way to fulfill your true potential.");
        pagesContent.addElement("The Book in Three Sentences: The only thing you have that nobody else has is control of your life. The hardest thing of all is to learn to love the journey, not the destination. Get a real life rather than frantically chasing the next level of success.");
        pagesContent.addElement("The Book in Three Sentences: An idea occurs when you develop a new combination of old elements. The capacity to bring old elements into new combinations depends largely on your ability to see relationships. All ideas follow a five-step process of 1) gathering material, 2) intensely working over the material in your mind, 3) stepping away from the problem, 4) allowing the idea to come back to you naturally, and 5) testing your idea in the real world and adjusting it based on feedback.");
        pagesContent.addElement("The Book in Three Sentences: Seek out new ideas and try new things. When trying something new, do it on a scale where failure is survivable. Seek out feedback and learn from your mistakes as you go along.");
    }


    static Vector<Book> writeBooks() {

        Vector<Book> new_books = new Vector<>();

        Random rand = new Random();

        for (Integer i = 0; i < defaultBookNumbers; i++) {
            Book new_book = new Book();
            new_book.name = names.elementAt(rand.nextInt(5));
            new_book.author = authors.elementAt(rand.nextInt(5));
            new_book.pages = pageWriter();

            new_books.addElement(new_book);

        }
        return new_books;
    }

    private static Vector<Page> pageWriter() {

        Vector<Page> pages = new Vector<>();

        Random random = new Random();
        for (Integer i = 0; i < 10; i++) {
            Page new_page = new Page();
            new_page.setPageNumber(i);
            new_page.setPage_content(pagesContent.elementAt(random.nextInt(5)));
            pages.addElement(new_page);
        }

        return pages;

    }


}
