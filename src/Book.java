public class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return author + ", " + title;
    }

    public int getShelf() {
        return 0;
    }

    public String getCloset() {
        return "";
    }

    public int getFloor() {
        return 0;
    }

}
