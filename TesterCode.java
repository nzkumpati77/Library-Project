import java.util.Scanner;

public class TesterCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library smokyHill = new Library(5, true, 4); // Create a Library object
        smokyHill.fillLibrary();
        smokyHill.fillMusicLibrary(); // Optional: Pre-fill books

        System.out.println("What are you looking for? Books or Music (1/2)? :: ");
        int choice = input.nextInt();
        input.nextLine(); // clear newline

        // If user chooses to view books
        if (choice == 1) { 
            System.out.println("I would like to buy a book (type 3)\n" +
                               "I would like to donate a book (type 4)\n" +
                               "I'm just browsing (type 5)");
            int bookChoice = input.nextInt();
            input.nextLine(); // clear newline
            
            // If user chooses to buy a book, code also checks if library has enough books for what user wants
            if (bookChoice == 3) {
                System.out.println("What book were you looking for? ");
                String wanted = input.nextLine();

                if (smokyHill.isInStock(wanted)) {
                    System.out.println("We have it! How many were you looking for?");
                    int num = input.nextInt();
                    input.nextLine(); // clear newline

                    if (smokyHill.canBuy(wanted, num)) {
                        smokyHill.bookBought(wanted, num);
                        System.out.println("We have enough in stock! We hope you enjoy! Come back again!");
                    } else {
                        System.out.println("We don't have enough in stock, sorry! Come back again!");
                    }
                } else {
                    System.out.println("Sorry, we don't have that. Come back again!");
                }
                // If user chooses to donate a book to the library
            } else if (bookChoice == 4) {
                System.out.println("Please enter the book title: ");
                String title = input.nextLine();
                System.out.println("Now enter the genre: ");
                String genre = input.nextLine();

                smokyHill.addToLibrary(title, genre);
                System.out.println("Thanks for donating! Here's our updated library:");
                System.out.println(smokyHill.getBooks());
                // If user doesn't choose to donate a book or buy a book, then this will just display the library books 
            } else {
                System.out.println("Awesome! Here's our collection of books:");
                System.out.println(smokyHill.getBooks());
                System.out.println("Here's our collection of Music:");
                System.out.println(smokyHill.getMusic());
                System.out.println("Run the program again to buy or donate a book! Thanks for visiting Smoky Hill!");
            }
        } 
        // If user chooses to view library's music catalog
        else if (choice == 2) {
            System.out.println("Awesome! Here is our Music Selection :: ");
            System.out.println(smokyHill.getMusic());
            System.out.println("We hope you enjoy!");
        } 
        
        
        
        
        else {
            System.out.println("Invalid option. Please restart the program."); // If the user doesn't input the option given
        }

        
        
        
        
        
        input.close();
    }
}
