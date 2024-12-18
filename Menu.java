/**
 * Menu interface acts as a contract to all the menus
 * therefore, every menu available must implement the two methods provided by Menu interface
 */
public interface Menu {
    void display();
    void process(String input, char userInput, Library library, State state) throws Exception;
}
