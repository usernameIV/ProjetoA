class Loan {

    private int reserveId;
    private Book book;
    private User user;
    private String reservationDate;
    private String devolutionDate;

    public Loan(int reserveId,
                Book book,
                User user,
                String reservationDate,
                String devolutionDate) {

        this.reserveId = reserveId;
        this.book = book;
        this.user = user;
        this.reservationDate = reservationDate;
        this.devolutionDate = devolutionDate;
    }
    public int getReserveId() {
        return reserveId;
    }
    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    public String getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
}