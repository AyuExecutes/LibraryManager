/**
 * IdSearchMenu is the menu where user can find item by id.
 */
public class IdSearchMenu implements Menu {

    public  void display(){
        System.out.println("Enter ID to start search, or enter 'b' to go back to choose search method");
    }

    public void process(String input, char userInput, Library library, State state){
        switch (userInput){
            case 'b':
                state.setCurrentMenu("main_menu");
                break;

            default:
                // search for the id of input
                LibraryItem item = library.searchItemById(Integer.parseInt(input));

                if (item != null){
                    System.out.println(item);
                    state.setCurrentFoundItem(item);
                    // if it is found, display it, then go to selected item menu
                    state.setCurrentMenu("selected_item_menu");
                } else {
                    // otherwise display did not find it, re show the same menu
                    System.out.println("Item not available.");
                }
                break;
        }
    }
}
