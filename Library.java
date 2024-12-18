import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Library {
    private final ArrayList<LibraryItem> items = new ArrayList<>();

    /**
     * to add library item (either book/journal/movie)
     * @param libraryItem library item
     */
    public void addItem(LibraryItem libraryItem){
        items.add(libraryItem);
    }

    /**
     * to display the summary of each item in the library (id, type, and title)
     */
    public void displayLibraryItems(){
        for (LibraryItem eachItem : items){
            System.out.println(eachItem.toString());
        }
    }

    /**
     * to sort items in the library
     */
    public void sortLibraryItems(){
        Collections.sort(items);
    }

    /**
     * to display all the library items including average rating, num of reviewers, then id, type, and title.
     */
    public void displayLibraryItemsIncludingReview(){
        for (LibraryItem eachItem : items){
            System.out.println(eachItem.getAvgRatingAndNumReviewers() + eachItem.toString());
        }
    }

    /**
     * to find an item by its id
     * @param id the id to find
     * @return the library item, or null if not found
     */
    public LibraryItem searchItemById(int id){
        for (LibraryItem eachItem : items){
            if (eachItem.getId() == id){
                return eachItem;
            }
        }
        return null;
    }

    /**
     * to find items by phrase on the title (case-insensitive)
     * @param phrase the phrase to find
     * @return the list of LibraryItems found
     */
    public ArrayList<LibraryItem> searchItemByPhrase(String phrase){
        ArrayList<LibraryItem> foundItems = new ArrayList<>();
        for (LibraryItem eachItem : items){
            if (eachItem.getTitle().toLowerCase().contains(phrase.toLowerCase())){
                foundItems.add(eachItem);
            }
        }
        return foundItems;
    }

    /**
     * load library items from the file.
     * @param fileName the file to load
     */
    public void loadFromFile(String fileName){
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null){
                String[] currentLine = line.split(",");
                String type = currentLine[0];

                int id = Integer.parseInt(currentLine[1]);
                String title = currentLine[2];
                int year = Integer.parseInt(currentLine[3]);

                if (type.equals("Movie")){
                    String director = currentLine[4];
                    Movie movie = new Movie(type, id, title, year, director);
                    this.addItem(movie);

                } else if (type.equals("Book")){
                    String author = currentLine[4];
                    int numberOfPages = Integer.parseInt(currentLine[5]);
                    Book book = new Book(type, id, title, year, author, numberOfPages);
                    this.addItem(book);

                } else if (type.equals("Journal")){
                    int volume = Integer.parseInt(currentLine[4]);
                    int number = Integer.parseInt(currentLine[5]);
                    Journal journal = new Journal(type, id, title, year, volume, number);
                    this.addItem(journal);
                }
            }
        } catch (IOException e){
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
