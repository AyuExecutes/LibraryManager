public class Movie extends LibraryItemBase {
    private final String director;

    /**
     * constructor of Movie.
     * @param type the type
     * @param id the id
     * @param title the title
     * @param year the year
     * @param director the director
     */
    public Movie(String type, int id, String title, int year, String director){
        super(type, id, title, year, 7);            // movie's maximum borrowing time is set to 7 (7 days)
        this.director = director;
    }

    /**
     * to get the director of the movie.
     * @return the director
     */
    public String getDirector(){
        return this.director;
    }

    /**
     * this is the method that must be implemented from LibraryItemBase, which display extra detail that only movie has
     * such as the director.
     */
    protected void displayExtraDetails(){
        System.out.printf("Director: %s%n", getDirector());
    }
}
