import java.util.*;

public class Book
{
    private String name; // Instance Variables
    private String genre;
    public Book() {} // Overloaded constructors
    
    public Book(String n, String a) {
        name = n;
        genre = a;
    }

    public String toString() // To string method
    {
        return "" + getName() + " " + getGenre();
    }


    public String getName() {return name;} // Accesor methods
    public String getGenre() {return genre;}

}