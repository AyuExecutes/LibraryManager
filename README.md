# Library Manager - A Java Application for Managing Books, Journals, and Movies.
Library Manager is a Java-based application that allows users to manage and interact with a library of items, including books, journal, and movies.
The system provides features such as borrowing items, rating them, and searching by ID or phrase in titles.

---

## Features
- **Add and manage library items**: Books, journals, and movies with their unique attributes.
- **Borrow items**: Check item availability and set due dates based on the item type.
- **Rate items**: Provide ratings (0 - 10) and calculate average ratings with the total number of reviews.
- **Search functionality**: 
    - Search by **ID**: Find items by their unique ID.
    - Search by **phrase**: Find items by searching for a phrase in their title.
- **Item sorting**: Sort items by rating (descending) and ID (ascending).
- **Interactive menu**: Navigate through various menus to perform actions like borrowing, rating, and returning items.

---

## System Design
### Classes and Responsibilities
1. **LibraryItemBase** (Abstract Base Class):
Shared functionality for all library items (books, journals, movies).
- Provides fields like 'type', 'id', 'title', 'year', 'maxBorrowingTime', etc.
- Implements common methods: 'getDueDateDisplay', 'getAverageRating', etc.
- Enforces implementation of 'displayExtraDetails()' in subclasses.

2. **Book, Journal, Movie**:
Specific implementation of library items:
- **Book**: includes 'author' and 'numberOfPages'.
- **Journal**: includes 'volume' and 'number'.
- **Movie**: includes 'director'.

3. **Library**:
Manages library items:
- Add, search, sort, and display items.
- Load items from a file ('library_data.txt').

4. **Menu Classes**:
Implements an interactive system for user actions:
- **MainMenu**: Starting point for user interaction.
- **IdSearchMenu** and **PhraseSearchMenu**: Allow item search by ID or title phrases.
- **BorrowOrRateMenu**, **ReturnOrRateMenu**, and **RatingMenu**: Handle borrowing, returning, and rating items.
- **FullMenu**: Manages all menus and user state.

5. **State**:
Stores the application's current state:
- Current menu, selected item, search results, etc.

6. **LibraryManager**:
Entry point ('main') of the program. Loads data, displays items, and starts the menu loop.

---

## Usage
### Prerequisites
- **Java 8 or higher** installed on your machine.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse, or VSCode) or the terminal for compiling and running the program.


### Run the Program
Compile and run the program using the following steps:
```
javac LibraryManager.java
java LibraryManager
```

### Add or Modify Library Data
Edit the `library_data.txt` file to add or update library items. Ensure the format matches the following:
```
Book,231,The Great Gatsby,1925,F. Scott Fitzgerald,218
Journal,281,Journal of Software Engineering,2009,35,12
Movie,200,The Wizard of Oz,1939,Victor Fleming
```



