import java.util.*;

public class Music
{
    private String name;
    private String author;
    private double price; // Instance variables
    public Music() {}
    
    public Music(String n, String a, double b) { // Overloaded constructor
        name = n;
        author = a;
        price = b;
    }

    public String toString() // To sring method
    {
        return "" + getName() + " " + getAuthor();
    }


    public String getName() {return name;} // Accesor methods
    public double getPrice() {return price;}
    public String getAuthor() {return author;}

}