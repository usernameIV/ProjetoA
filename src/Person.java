public class Person {
    private long id;
    private String name;
    private String publicPlace;
    private String neighbourhood;
    private String city;
    private String state;
    private String zipCode;
    private long individualRegistry;
    private long identityCard;
    private String phone;
    private String email;
    private String userRegisterDate;
    private String birthdayDate;

    public Person(long id, String name, String publicPlace, String neighbourhood, String city, String state, String zipCode, long individualRegistry, long identityCard, String phone, String email, String userRegisterDate, String birthdayDate) {
        this.id = id;
        this.name = name;
        this.publicPlace = publicPlace;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.individualRegistry = individualRegistry;
        this.identityCard = identityCard;
        this.phone = phone;
        this.email = email;
        this.userRegisterDate = userRegisterDate;
        this.birthdayDate = birthdayDate;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPublicPlace() {
        return publicPlace;
    }
    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }
    public String getNeighbourhood() {
        return neighbourhood;
    }
    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }
    public long getIndividualRegistry() {
        return individualRegistry;
    }
    public void setIndividualRegistry(long individualRegistry) {
        this.individualRegistry = individualRegistry;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public long getIdentityCard() {
        return identityCard;
    }
    public void setIdentityCard(long identityCard) {
        this.identityCard = identityCard;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserRegisterDate() {
        return userRegisterDate;
    }
    public void setUserRegisterDate(String userRegisterDate) {
        this.userRegisterDate = userRegisterDate;
    }
    public String getBirthdayDate() {
        return birthdayDate;
    }
    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}
