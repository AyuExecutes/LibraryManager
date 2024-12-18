import java.util.Calendar;

/**
 * the LibraryItem interface acts as contract between all the Library Item types.
 * allowing to store all the Library Items in one list, as long as they implement this interface.
 * methods in this interface are common methods that all the items have in common.
 * by extending Comparable, the items can be sorted.
 */
public interface LibraryItem extends Comparable<LibraryItem> {
    String getType();
    int getId();
    String getTitle();
    int getYear();
    double getAverageRating();
    String getAvgRatingAndNumReviewers();
    boolean isAvailable();
    void setAvailable(boolean available);
    void addRating(int rating) throws Exception;
    Calendar getDueDateAsCalendar();
    void displayItemFullDetails();
    String getDueDateDisplay();
}
