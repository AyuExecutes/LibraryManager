/**
 * BorrowOrRateMenu is the menu where user can choose to borrow / rate the item, and go back to main menu.
 */
public class BorrowOrRateMenu implements Menu {

    public void display(){
        System.out.println("Enter 'b' to borrow the item, enter 'a' to rate the item, or enter any other key to restart");
    }

    public void process(String input, char userInput, Library library, State state){
        switch (userInput){
            case 'b':
                // when borrow is selected, item set to unavailable, due date is shown, and item details are displayed
                state.getCurrentSelectedItem().setAvailable(false);
                System.out.printf("The item's due date is %s%n", state.getCurrentSelectedItem().getDueDateDisplay());
                state.getCurrentSelectedItem().displayItemFullDetails();
                state.setCurrentMenu("return_or_rate_menu");            // set the current menu to return or rate menu
                break;
            case 'a':
                // go to rating menu, set rating
                state.setPreviousMenu("borrow_or_rate_menu");
                state.setCurrentMenu("rating_menu");
                break;

            default:
                state.setCurrentMenu("main_menu");
                break;
        }
    }
}
