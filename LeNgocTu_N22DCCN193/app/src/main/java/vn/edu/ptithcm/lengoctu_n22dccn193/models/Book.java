package vn.edu.ptithcm.lengoctu_n22dccn193.models;

public class Book {
    private String title;
    private String author;
    private int img;
    private double price;

    public Book(String title, String author, int img, double price) {
        this.title = title;
        this.author = author;
        this.img = img;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
