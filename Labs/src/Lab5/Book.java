
public class Book {

    private String title;
    private Person auther;
    private int publishYear;
    private static int count = 0;

    Book(String title, String fName, String lName, int publishYear) {
        this.title = title;
        this.publishYear = publishYear;
        this.auther = new Person(fName, lName);
        this.count = count + 1;

    }

    Book(String title, Person auther, int publishYear) {
        this.title = title;
        this.publishYear = publishYear;
        this.auther = auther;
        this.count = count + 1;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuther(Person auther) {
        this.auther = auther;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuther() {
        return auther;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String toString() {
        return title + ", " + auther + ", " + publishYear;
    }

    public static int getCount() {
        return count;
    }

}
