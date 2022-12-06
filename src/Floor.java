public class Floor {
    private int number;
    private MyLinkedList<Closet> closetList = new MyLinkedList<>();

    public Floor(int number) {
        this.number = number;

        for (int i = 0; i < 30; i++) {
            closetList.add(new Closet("C" + (i + 1)));
        }
    }

    public boolean add(Book book, String closet, int shelf) {
        // library.add(book1, "C1", 1);
        Closet closetObj = getClosedByName(closet);
        if (closetObj == null) {
            return false;
        }
        return closetObj.add(book, shelf);
    }

    public Closet getClosedByName(String name) {
        for (Closet closet : closetList) {
            if (closet.getName().equals(name)) {
                return closet;
            }
        }
        return null;
    }

    public boolean contains(String closet, int shelf, Book book) {
        // contains("C1", 1, book1);
        Closet closetObj = getClosedByName(closet);
        if (closetObj == null) {
            return false;
        }
        return closetObj.contains(shelf,book);
    }


    public String getBooks(String closet) {
        Closet closetObj = getClosedByName(closet);
        if (closetObj == null) {
            return null;
        }
        return closetObj.getBooks();
    }
}
