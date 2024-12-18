import static java.lang.System.exit;

/**
 * MainMenu is the first menu for user to interact with the library system.
 * providing options to sort/search by id/search by phrase/quit.
 */
public class MainMenu implements Menu {

    public void display(){
        System.out.println("Enter 'q' to quit,");
        System.out.println("or enter 's' to sort (first by average rating and then by id) and display all items,");
        System.out.println("or enter 'i' to search by ID,");
        System.out.println("or enter any other key to search by phrase in title");
    }

    public void process(String input, char userInput, Library library, State state){
        switch (userInput) {
            case 'q':
                exit(0);

            case 's':
                library.sortLibraryItems();
                library.displayLibraryItemsIncludingReview();
                break;

            case 'i':
                state.setCurrentMenu("id_search_menu");
                break;

            default:
                state.setCurrentMenu("phrase_search_menu");
                break;

        }
    }
}
