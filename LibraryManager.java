public class LibraryManager {
    public static void main(String[] args){
        Library library = new Library();
        library.loadFromFile("library_data.txt");           // load the library data from the .txt file

        System.out.println("List of all items in the library: ");
        library.displayLibraryItems();                              // display the summary of all library items

        FullMenu fullMenu = new FullMenu();
        fullMenu.startMenuLoop(library);                            // start the menu loop
    }
}
