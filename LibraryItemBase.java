import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

/**
 * LibraryItemBase is the common implementation that all the 3 types of items (Book, Journal, Movie) share.
 */
public abstract class LibraryItemBase implements LibraryItem {
    List<Integer> listOfRating = new ArrayList<>();   // Used for calculating average rating
    private final String type;
    private final int id;
    private final String title;
    private final int year;
    private final int maxBorrowingTime;
    private int numberOfReviews;
    private boolean available;
    private Calendar dueDate;

    /**
     * Constructor
     * initially, item is set to available.
     * @param type the type
     * @param id the id
     * @param title the title
     * @param year the year
     */
    public LibraryItemBase(String type, int id, String title, int year, int maxBorrowingTime){
        this.type = type;
        this.id = id;
        this.title = title;
        this.year = year;
        this.available = true;
        this.maxBorrowingTime = maxBorrowingTime;
    }

    /**
     * to get the item's type
     * @return the type
     */
    public String getType(){
        return this.type;
    }

    /**
     * to get the item's id
     * @return the id
     */
    public int getId(){
        return this.id;
    }

    /**
     * to get the item's title
     * @return the title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * to get the item's year
     * @return the year
     */
    public int getYear(){
        return this.year;
    }

    /**
     * to get the item's average rating
     * @return the average rating
     */
    public double getAverageRating(){
        double averageRating = 0.0;
        int count = listOfRating.size();                // get the total number of ratings

        for (Integer integer : listOfRating) {
            averageRating = averageRating + integer;    // sum all the ratings
        }

        if (!(count == 0)){                             // check if there are ratings, then calculate the average
            averageRating = averageRating / count;
        } else {
            averageRating = 0.0;                        // set average rating to 0 if there are no ratings
        }

        return averageRating;
    }

    /**
     * to get the item total number of reviews
     * @return number of reviews
     */
    public int getNumberOfReviews(){
        return this.numberOfReviews;
    }

    /**
     * to set availability of the item
     * @param available the availability status
     */
    public void setAvailable(boolean available){
        this.available = available;

        if (!available){
            Calendar rightNow = Calendar.getInstance();
            rightNow.add(Calendar.DATE, maxBorrowingTime);      // set the due date to maxBorrowingTime days from now
            this.dueDate = rightNow;
        }
    }

    /**
     * to get the item's due date
     * @return item's due date
     */
    public Calendar getDueDateAsCalendar(){
        return this.dueDate;
    }

    /**
     * to check if item is available
     * @return the availability status
     */
    public boolean isAvailable(){
        return this.available;
    }

    /**
     * Output the format as ID: [id] Type: [type] Title: [title]
     * @return the formatted string.
     */
    @Override
    public String toString() {
        return String.format("ID: %-10s Type: %-15s Title: %-30s", getId(), getType(), getTitle());
    }

    /**
     * to get the item's rating and number of reviewers
     * @return formatted String of item rating and number of reviewers
     */
    public String getAvgRatingAndNumReviewers(){
        double averageRating = Math.floor(getAverageRating() * 100) / 100;          // get the average rating to 2 decimal places without rounding
        return String.format("Average rating: %-10.2f Number of reviewers: %-10d", averageRating, getNumberOfReviews());
    }

    /**
     * to get the due date display (in format of year/month/day)
     * @return the formatted due date
     */
    public String getDueDateDisplay(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDueDate;
        Date date = getDueDateAsCalendar().getTime();
        // use simpleDateFormat to format the date into a String.
        formattedDueDate = simpleDateFormat.format(date);
        return formattedDueDate;
    }

    /**
     * Compare this item to the other item to compare to (in descending order for rating, ascending order for id)
     * Primarily sorted by average rating, then by id.
     * returning negative value will cause this item to be appeared before.
     * returning positive value will cause this item to be appeared after.
     * returning zero value will cause item to stay in this position (equal).
     * @param itemToCompareTo the object to be compared.
     * @return int value that represents how the current object should be ordered.
     */
    @Override
    public int compareTo(LibraryItem itemToCompareTo) {

        // get the average rating, then flip it by subtracting it from 10 (max of rating number)
        // then remove decimal places after 2
        // then move precision by 3 digits
        // and add the id
        // For example:
        //            thisItem's average rating is 9.561234 and id is 202 then it becomes 043202
        //            compareItem's average rating is 1.222 and id is 281 then it becomes 877281
        //            then thisItem - compareItem becomes negative. So, thisItem will come first, which is descending order.

        // calculate thisItem
        int thisItem = (int)(Math.floor((10 - this.getAverageRating()) * 100) * 1000);
        thisItem = thisItem + this.getId();

        // calculate compareItem
        int compareItem = (int)(Math.floor((10 - itemToCompareTo.getAverageRating()) * 100) * 1000);
        compareItem = compareItem + itemToCompareTo.getId();

        return thisItem - compareItem;
    }

    /**
     * add a rating to this item
     * throws an exception if the rating value is out of bounds
     * @param rating the rating (allowed values are between 0 - 10)
     * @throws Exception exception will be thrown if value is not between 0 - 10
     */
    public void addRating(int rating) throws Exception {
        if (rating < 0 || rating > 10) {
            throw new Exception("Invalid rating. Must be between 0 - 10");
        }
        listOfRating.add(rating);
        numberOfReviews++;
    }

    /**
     * this is an example of polymorphism. Where all the children (book, journal, movie) must implement this method, but they have their own implementation.
     * using protected because only the subclasses will have access to this method.
     */
    protected abstract void displayExtraDetails();

    /**
     * display the full details of this library item.
     * there is an abstract method called displayExtraDetails(), which does not have an implementation in this class,
     * but child classes must implement this method in their own unique way, displaying unique extra information that each of them has.
     */
    public void displayItemFullDetails(){
        System.out.println("\nSelected item is:");
        System.out.printf("Type: %s%n", this.getType());
        System.out.printf("Title: %s%n", this.getTitle());
        System.out.printf("ID: %d%n", this.getId());
        System.out.printf("Year: %d%n", this.getYear());
        System.out.printf("Average rating: %.1f%n", this.getAverageRating());
        System.out.printf("Number of reviewers: %d%n", this.getNumberOfReviews());
        System.out.printf("Status: %s%n", this.isAvailable() ? "available" : "on loan");
        if (!this.isAvailable()){
            System.out.printf("Due date: %s%n", getDueDateDisplay());
        }

        displayExtraDetails();      // display book/journal/movie unique extra detail/s

        System.out.printf("Max number of days for borrowing: %d%n", this.maxBorrowingTime);
        System.out.println();
    }
}
