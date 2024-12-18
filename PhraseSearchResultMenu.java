import java.util.ArrayList;

/**
 * PhraseSearchResultMenu is the menu for the list of items found by phrase search.
 * user then can select the selected item from the list.
 */
public class PhraseSearchResultMenu implements Menu {
    public void display(){
        System.out.println("Enter item number to select item, or enter any other key to continue searching");
    }

    public void process(String input, char userInput, Library library, State state) throws Exception {
        ArrayList<LibraryItem> foundItemsList = state.getCurrentFoundItems();
        int number;
        try {
            // turn user input into integer
            number = Integer.parseInt(input);
        } catch (NumberFormatException e){
            state.setCurrentMenu("phrase_search_menu");
            return;
        }
        // validate the number entered.
        if (number < 1 || number > foundItemsList.size()){
            throw new Exception("Invalid input. Requires 1 - " + foundItemsList.size());
        }
        // find the item in the list
        LibraryItem selectedItem = foundItemsList.get(number - 1);
        // display the item
        selectedItem.displayItemFullDetails();
        // set the currently selected item in the state
        state.setCurrentSelectedItem(selectedItem);
        if (state.getCurrentSelectedItem().isAvailable()){
            state.setCurrentMenu("borrow_or_rate_menu");
        } else {
            state.setCurrentMenu("return_or_rate_menu");
        }
    }
}
