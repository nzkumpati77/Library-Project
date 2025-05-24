import java.util.ArrayList;

public class Library {
    private int numBooks; //Instance variables 
    private int numSongs;
    private boolean hasMusic;
    private ArrayList<Book> books; // ArrayLists of both books and Music
    private ArrayList<Music> songs;

    public Library() {
        books = new ArrayList<>();
        songs = new ArrayList<>();
    }

    public Library(int i, boolean b, int c) {
        numBooks = i;
        hasMusic = b;
        numSongs = c;
        books = new ArrayList<>();
        songs = new ArrayList<Music>(); // Overloaded constructors
    }

    public int getNumBooks() { // Accesor methods
        return numBooks;
    }

    public boolean getHasMusic() {
        return hasMusic;
    }

    public String getBooks() {
        String s = "";
        for (Book b : books) {
            s += b.toString() + "\n";
        }
        return s;
    }

    public String getMusic() {
        String s = "";
        for (Music b : songs) {
            s += b.toString() + "\n";
        }
        return s;
    }
    // Adds a book to the library through appending a book to the books list
    public void addToLibrary(String name, String genre) {
        books.add(new Book(name, genre));
        numBooks++;
    }
    // Adds a song to the library through appending a song to the songs list
    public void addMusic(String name, String genre, double p) {
        songs.add(new Music(name, genre, p));
        numSongs++;
    }
    // Checks if the book the user wants is in stock
    public boolean isInStock(String query) {
        for (Book b : books) {
            if (query.equals(b.getName()) || query.equals(b.getGenre())) {
                return true;
            }
        }
        return false;
    }
    // Checks if the amount the user wants is in the books list
    public boolean canBuy(String query, int numWanted) {
        int count = 0;
        for (Book b : books) {
            if (query.equalsIgnoreCase(b.getName()) || query.equalsIgnoreCase(b.getGenre())) {
                count++;
            }
        }
        return count >= numWanted;
    }

    public void bookBought(String query, int quantity) { // Removes the book from the books list if they buy a book
        int removed = 0;
        for (int i = 0; i < books.size() && removed < quantity; i++) {
            if (query.equalsIgnoreCase(books.get(i).getName()) || query.equalsIgnoreCase(books.get(i).getGenre())) {
                books.remove(i);
                i--; // adjust for removal
                removed++;
                numBooks--;
            }
        }
    }

    public void fillLibrary() {
        // Check if there are at least 2 books to fill
        if (numBooks >= 2) {
            // Calculate the number of books for each genre
            int numHillBilly = (int)(0.25 * numBooks);  // 25% of the total
            int numMockingbird = (int)(0.25 * numBooks);
            int numDiary = (int)(0.25 * numBooks);
            int numAmericanGun = numBooks - (numHillBilly + numMockingbird + numDiary);  // The rest goes to American Gun
    
            // Add the calculated number of books to the library
            for (int j = 0; j < numHillBilly; j++) addToLibrary("HillBilly Elegy", "Autobiography");
            for (int j = 0; j < numMockingbird; j++) addToLibrary("To Kill a Mockingbird", "Fiction");
            for (int j = 0; j < numDiary; j++) addToLibrary("Diary of a Wimpy Kid", "Comedy");
            for (int j = 0; j < numAmericanGun; j++) addToLibrary("American Gun", "Nonfiction");
        } else {
            // If numBooks is too low, you can add a default number of books
            addToLibrary("HillBilly Elegy", "Autobiography");
            addToLibrary("To Kill a Mockingbird", "Fiction");
        }
    }

    public void fillMusicLibrary() {
        if (numSongs >= 2) {
            // Calculate the number of songs for each composer
            int numMozart = (int)(0.25 * numSongs);  // 25% of the total
            int numBach = (int)(0.25 * numSongs);
            int numBeethoven = (int)(0.25 * numSongs);
            int numKey = numSongs - (numMozart + numBach + numBeethoven);  // The rest goes to Francis Scott Key
    
            // Add the calculated number of books to the library
            for (int j = 0; j < numMozart; j++) addMusic("Piano Sonato No. 10", "Mozart", 5.99);
            for (int j = 0; j < numBach; j++) addMusic("Brandenburg Concertos", "Bach", 2.99);
            for (int j = 0; j < numBeethoven; j++) addMusic("Fur Elise", "Beethoven", 3.99);
            for (int j = 0; j < numKey; j++) addMusic("Star Spangled Banner", "Key", 4.99);
        } else {
            // If numSongs is too low, you can add a default number of songs
            addMusic("Piano Sonato No. 10", "Mozart", 5.99);
            addMusic("Brandenburg Concertos", "Bach", 2.99);
        }
    }


    @Override
    public String toString() { // To string method
        return "Library with " + numBooks + " books. Has music: " + hasMusic;
    }
}
