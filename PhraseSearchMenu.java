import java.util.ArrayList;

/**
 * phrase search menu is the menu to find item by phrase.
 */
public class PhraseSearchMenu implements Menu {
    public void display(){
        System.out.println("Enter phrase in title to start search, or enter 'b' to go back to choose search method");
    }

    public void process(String input, char userInput, Library library, State state){
        switch (userInput){
            case 'b':
                state.setCurrentMenu("main_menu");
                break;

            default:
                ArrayList<LibraryItem> foundItemsList = library.searchItemByPhrase(input);
                // if the list has items
                if (!foundItemsList.isEmpty()){
                    // display each item
                    for (int i = 0; i < foundItemsList.size(); i++){
                        System.out.printf("* %d:%n", i + 1);
                        System.out.println(foundItemsList.get(i).toString());
                        System.out.println();
                    }
                    // go to PhraseSearchResultMenu
                    state.setCurrentFoundItems(foundItemsList);
                    state.setCurrentMenu("phrase_search_result_menu");
                } else {
                    System.out.println("No item/s found.");
                }
                break;
        }
    }
}
