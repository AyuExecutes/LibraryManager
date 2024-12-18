/**
 * ReturnOrRateMenu is the menu where user can return/rate the item they borrowed, and go back to main menu.
 */
public class ReturnOrRateMenu implements Menu {
    public void display(){
        System.out.println("Enter 'r' to return the item, enter 'a' to rate the item, or enter any other key to restart");
    }

    public void process(String input, char userInput, Library library, State state){
        switch (userInput){
            case 'r':
                state.getCurrentSelectedItem().setAvailable(true);
                System.out.println("This item is returned");
                // display item
                state.getCurrentSelectedItem().displayItemFullDetails();
                // back to borrow or rate menu
                state.setCurrentMenu("borrow_or_rate_menu");
                break;

            case 'a':
                // go to rating menu, set rating
                state.setPreviousMenu("return_or_rate_menu");
                state.setCurrentMenu("rating_menu");
                break;

            default:
                state.setCurrentMenu("main_menu");
                break;
        }
    }
}
