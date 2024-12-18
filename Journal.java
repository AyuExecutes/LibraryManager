public class Journal extends LibraryItemBase {
    private final int volume;
    private final int number;

    /**
     * constructor of Journal.
     * @param type the type
     * @param id the id
     * @param title the title
     * @param year the year
     * @param volume the volume
     * @param number the number
     */
    public Journal(String type, int id, String title, int year, int volume, int number){
        super(type, id, title, year, 14);           // Journal's maximum borrowing time is set to 14 days.
        this.volume = volume;
        this.number = number;
    }

    /**
     * to get the volume of the journal
     * @return the volume
     */
    public int getVolume(){
        return this.volume;
    }

    /**
     * to get the number of the journal
     * @return the number
     */
    public int getNumber(){
        return this.number;
    }

    /**
     * this is the method that must be implemented from LibraryItemBase, which display extra detail that only journal has
     * such as the volume and number.
     */
    protected void displayExtraDetails(){
        System.out.printf("Volume: %d%n", getVolume());
        System.out.printf("Number: %d%n", getNumber());
    }
}
