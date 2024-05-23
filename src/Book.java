class Book {

    private long catalogNumber;
    private String title;
    private String author;
    private String category;
    private String editor;
    private String year;
    private String registerDate;
    private String situation;

    public Book(long catalogNumber,
                String title,
                String author,
                String category,
                String editor,
                String year,
                String registerDate,
                String situation) {

        this.catalogNumber = catalogNumber;
        this.title = title;
        this.author = author;
        this.category = category;
        this.editor = editor;
        this.year = year;
        this.registerDate = registerDate;
        this.situation = situation;
    }
    public long getCatalogNumber() {
        return catalogNumber;
    }
    public void setCatalogNumber(long catalogNumber) {
        this.catalogNumber = catalogNumber;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getEditor() {
        return editor;
    }
    public void setEditor(String editor) {
        this.editor = editor;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
    public String getSituation() {
        return situation;
    }
    public void setSituation(String situation) {
        this.situation = situation;
    }

}