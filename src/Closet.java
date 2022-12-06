public class Closet {
    private String name;
    private MyLinkedList<Shelf> shelfList = new MyLinkedList<>();

    public Closet(String name) {
        this.name = name;
        for (int i = 0; i < 6; i++) {
            shelfList.add(new Shelf(i + 1));
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean add(Book book, int shelf) {
        Shelf shelfObj = shelfList.get(shelf - 1);
        return shelfObj.add(book);
    }

    public boolean contains(int shelf, Book book) {
        // contains(1, book1);
        Shelf shelfObj = shelfList.get(shelf - 1);
        return shelfObj.contains(book);
    }

    public String getBooks() {
        /*Shelf 1
        muallifi_1, moni_1
        muallifi_2, moni_2
        Shelf 2*/

        String str = "";
        for (Shelf shelf : shelfList) {
            str += "Shelf " + shelf.getNumber() +"\n";
            str += shelf.getBooks();
        }
        // Shelf 1
        //  muallifi_1, moni_1\n
        //  muallifi_2, moni_2\n
        // Shelf 2
        // Shelf 3
        // Shelf 4
        // Shelf 5
        // Shelf 6

        return str;
    }
}
