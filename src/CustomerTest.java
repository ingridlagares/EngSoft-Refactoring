import org.junit.Test;
import static org.junit.Assert.*;

class CustomerTest {
    @Test
    void testStatement() {
        Customer customer1 = new Customer("Maria");

        assertEquals(
            "Rental Record for Maria\n"
            + "Amount owed is 0.0\n"
            + "You earned 0 frequent renter points",
            customer1.statement()
        );

        Movie movie1 = new Movie(
            "Os Sonhadores",
            Movie.REGULAR
        );

        Movie movie2 = new Movie(
            "Pierrot Le Fou",
            Movie.NEW_RELEASE
        );

        customer1.addRental(new Rental(movie1, 12));

        assertEquals(
            "Rental Record for Maria\n"
            + "\tOs Sonhadores\t17.0\n"
            + "Amount owed is 17.0\n"
            + "You earned 1 frequent renter points",
            customer1.statement()
        );

        customer1.addRental(new Rental(movie2, 10));

        assertEquals(
            "Rental Record for Maria\n"
            + "\tOs Sonhadores\t17.0\n"
            + "\tPierrot Le Fou\t30.0\n"
            + "Amount owed is 47.0\n"
            + "You earned 3 frequent renter points",
            customer1.statement()
        );
    }
} 
