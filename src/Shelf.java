public class Shelf {
    private Integer number;
    private MyLinkedList<Book> bookList = new MyLinkedList<>();

    public Shelf(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean add(Book book) {
        if (bookList.size() >= 10) {
            return false;
        }
        bookList.add(book);
        return true;
    }

    public boolean contains(Book book) {
        for (Book b : bookList) {
            if (b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor())) {
                return true;
            }
        }
        return false;
    }

    public String getBooks() {
        //  muallifi_1, moni_1\n
        //  muallifi_2, moni_2\n
        String str = "";
        for (Book book : bookList) {
            str += book.toString() +"\n";
        }
        return str;
    }
}
