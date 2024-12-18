import java.util.ArrayList;

/**
 * State class is a container that holds various states for the different menus (shared between the menus)
 * it is the data store for the state machine
 */
public class State {
    /**
     * for which menu should be display/process
     */
    private String currentMenu;

    /**
     * for which menu was the previous menu
     */
    private String previousMenu;

    /**
     * for the which LibraryItem was found in the id search menu.
     */
    private LibraryItem currentFoundItem;

    /**
     * for which LibraryItem was selected in either id search menu or the phrase search menu
     */
    private LibraryItem currentSelectedItem;

    /**
     * for what LibraryItem was found in the phrase search menu
     */
    private ArrayList<LibraryItem> currentFoundItems;

    /**
     * to set the current menu
     * @param currentMenu the current menu
     */
    public void setCurrentMenu(String currentMenu){
        this.currentMenu = currentMenu;
    }

    /**
     * to set the current found item
     * @param currentFoundItem the current found item
     */
    public void setCurrentFoundItem(LibraryItem currentFoundItem){
        this.currentFoundItem = currentFoundItem;
    }

    /**
     * to set the current selected item
     * @param currentSelectedItem the selected item
     */
    public void setCurrentSelectedItem(LibraryItem currentSelectedItem){
        this.currentSelectedItem = currentSelectedItem;
    }

    /**
     * to set the previous menu
     * @param previousMenu the previous menu
     */
    public void setPreviousMenu(String previousMenu){
        this.previousMenu = previousMenu;
    }

    /**
     * to set the current found items
     * @param currentFoundItems the current found items
     */
    public void setCurrentFoundItems(ArrayList<LibraryItem> currentFoundItems){
        this.currentFoundItems = currentFoundItems;
    }

    /**
     * to get the current menu
     * @return current menu
     */
    public String getCurrentMenu(){
        return currentMenu;
    }

    /**
     * to get the current found item
     * @return current found item
     */
    public LibraryItem getCurrentFoundItem(){
        return currentFoundItem;
    }

    /**
     * to get the current selected item
     * @return the current selected item
     */
    public LibraryItem getCurrentSelectedItem(){
        return currentSelectedItem;
    }

    /**
     * to get the previous menu
     * @return the previous menu
     */
    public String getPreviousMenu(){
        return previousMenu;
    }

    /**
     * to get the current found items
     * @return the current found items
     */
    public ArrayList<LibraryItem> getCurrentFoundItems(){
        return currentFoundItems;
    }
}
