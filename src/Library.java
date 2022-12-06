public class Library {

    private MyLinkedList<Floor> floorList = new MyLinkedList<>();

    public Library() {
        floorList.add(new Floor(1)); // 0
        floorList.add(new Floor(2)); // 1
        floorList.add(new Floor(3)); // 2
    }

    public boolean add(Book book, int floor, String closet, int shelf) {
        // library.add(book1, 1, "C1", 1);
        Floor floorObj = floorList.get(floor - 1);
        return floorObj.add(book, closet, shelf);
    }

    public boolean contains(int floor, String closet, int shelf, Book book) {
        // contains(1, "C1", 1, book1);
        Floor floorObj = floorList.get(floor - 1);
        return floorObj.contains(closet,shelf,book);
    }

    public String getBooks(int floor, String closet) {
        Floor floorObj = floorList.get(floor - 1);
        return floorObj.getBooks(closet);
    }

    public Book find(String author, String title) {   // qatra korb chiq
        MyLinkedList<Book>books = new MyLinkedList<>();
        for(Book book: books){
            if(book.getAuthor().equals(author) && book.getTitle().equals(title)){
                return book;
            }
        }


        return null;
    }
}