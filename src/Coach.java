public class Coach extends Person{
    private String sport;
    public Coach(String firstName, String lastName, String phoneNumber, String coach) {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }

    public String toString() {
        return super.toString() + " Sport: " + sport;
    }
}
