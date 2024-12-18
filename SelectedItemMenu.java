/**
 * SelectedItemMenu is the menu that gives user option to select this item / go back to search again by id
 */
public class SelectedItemMenu implements Menu {
    public void display(){
        System.out.println("Enter 'i' to search other item by ID, or enter any other key to select this item");
    }

    public void process(String input, char userInput, Library library, State state){
        switch (userInput){
            case 'i':
                state.setCurrentMenu("id_search_menu");
                break;

            default:
                // store the selected item in the state
                state.setCurrentSelectedItem(state.getCurrentFoundItem());
                // display the selected item
                state.getCurrentSelectedItem().displayItemFullDetails();
                // navigate the relevant menu depending on the item's availability
                if (state.getCurrentSelectedItem().isAvailable()){
                    state.setCurrentMenu("borrow_or_rate_menu");
                } else {
                    state.setCurrentMenu("return_or_rate_menu");
                }
                break;
        }
    }
}
