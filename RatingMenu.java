/**
 * RatingMenu is the menu to rate an item.
 */
public class RatingMenu implements Menu {
    @Override
    public void display() {
        System.out.println("Please enter your rating (0 - 10)");
    }

    @Override
    public void process(String input, char userInput, Library library, State state) throws Exception {
        int rating = Integer.parseInt(input);
        LibraryItem item = state.getCurrentSelectedItem();
        item.addRating(rating);
        double averageRating = item.getAverageRating();
        System.out.printf("This item's new average rating is %.1f%n", averageRating);
        // display
        state.getCurrentSelectedItem().displayItemFullDetails();
        // goes back to previous menu
        state.setCurrentMenu(state.getPreviousMenu());
    }
}
