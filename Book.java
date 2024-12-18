public class Book extends LibraryItemBase {
    private final String author;
    private final int numberOfPages;

    /**
     * constructor for Book
     * @param type the type
     * @param id the id
     * @param title the title
     * @param year the year
     * @param author the author
     * @param numberOfPages the number of pages
     */
    public Book(String type, int id, String title, int year, String author, int numberOfPages){
        super(type, id, title, year, 28);       // book's maximum borrowing time is set to 28 (28 days).
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    /**
     * to get the author of the book
     * @return the author
     */
    public String getAuthor(){
        return this.author;
    }

    /**
     * to get the number of pages of the book
     * @return the number of pages
     */
    public int getNumberOfPages(){
        return this.numberOfPages;
    }

    /**
     * the method that must be implemented from LibraryItemBase, which display extra detail that only book has
     * such as the author and number of pages.
     */
    protected void displayExtraDetails(){
        System.out.printf("Author: %s%n", getAuthor());
        System.out.printf("Number of pages: %d%n", getNumberOfPages());
    }
}
