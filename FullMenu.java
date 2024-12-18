import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 * FullMenu is acting as the all the menu's manager.
 * using HashMap to store all the menus, key-ed by the menu name as the id
 */
public class FullMenu {
    private final State state = new State();
    private final Map<String, Menu> menuMap = new HashMap<String, Menu>();

    /**
     * constructor of FullMenu
     */
    public FullMenu(){
        state.setCurrentMenu("main_menu");          // initial menu is the main menu

        menuMap.put("main_menu", new MainMenu());
        menuMap.put("id_search_menu", new IdSearchMenu());
        menuMap.put("phrase_search_menu", new PhraseSearchMenu());
        menuMap.put("selected_item_menu", new SelectedItemMenu());
        menuMap.put("borrow_or_rate_menu", new BorrowOrRateMenu());
        menuMap.put("return_or_rate_menu", new ReturnOrRateMenu());
        menuMap.put("rating_menu", new RatingMenu());
        menuMap.put("phrase_search_result_menu", new PhraseSearchResultMenu());
    }

    /**
     * The menu loop.
     * @param library the library containing the library items
     */
    public void startMenuLoop(Library library){

        Scanner scanner = new Scanner(System.in);

        try {
            char userInput;

            while (true) {
                // get the current menu object
                Menu menu = menuMap.get(state.getCurrentMenu());
                // display the current menu message
                menu.display();
                // wait for user input
                String input = scanner.nextLine();
                try {
                    // making sure input is not empty
                    if (!input.isEmpty()) {
                        if (input.length() > 1){
                            // set it to x so that it does not match any menu option
                            userInput = 'x';
                        } else {
                            // get the first character
                            userInput = input.charAt(0);
                        }
                    } else {
                        throw new Exception("Invalid Input.");
                    }
                    // then process the input in the current menu
                    menu.process(input, userInput, library, state);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            scanner.close();
        }
    }
}


