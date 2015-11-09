package com.example.julietacisneros.listhotels;

/**
 * Created by julietacisneros on 06/11/15.
 */
public class ListEntry {

    private int image;
    private String hotelName;
    private String punctuation;
    private String description;

    public ListEntry (int image, String hotelName, String punctuation, String description) {
        this.image = image;
        this.hotelName = hotelName;
        this.punctuation = punctuation;
        this.description = description;
    }

    public String getHotelName() { return hotelName;}

    public String getPunctuation() {
        return punctuation;
    }

    public int getImage() { return image; }

    public String getDescription() { return description; }
}
