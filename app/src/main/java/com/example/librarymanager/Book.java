package com.example.librarymanager;

public class Book {
    private int id, pages;
    private String name, author, imageUrl, shortDescription;
    private boolean isExpanded;

    public Book(int id, int pages, String name, String author, String imageUrl, String shortDescription) {
        this.id = id;
        this.pages = pages;
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
        this.shortDescription = shortDescription;
        isExpanded = false;
    }

    public void expand(){
        isExpanded = true;
    }
    public void retract(){
        isExpanded = false;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public void toggleExpended(){
        if (isExpanded()) retract();
        else expand();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", pages=" + pages +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                '}';
    }
}
