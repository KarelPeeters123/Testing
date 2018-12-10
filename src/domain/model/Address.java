package domain.model;

public class Address {

    private String address, place;
    private int postalCode, houseNumber;

    public Address() {

    }

    public Address(String address, String place, int postalCode, int houseNumber) {
        setAddress(address);
        setPlace(place);
        setPostalCode(postalCode);
        setHouseNumber(houseNumber);
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }

    public void setPlace(String place) {
        if (place == null || place.trim().isEmpty()) throw new IllegalArgumentException("Invalid place");
        this.place = place;
    }

    public void setPostalCode(int postalCode) {
        if (postalCode < 0) throw new IllegalArgumentException("Invalid postal code");
        this.postalCode = postalCode;
    }

    public void setHouseNumber(int houseNumber) {
        if (houseNumber < 0) throw new IllegalArgumentException("Invalid house number");
        this.houseNumber = houseNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPlace() {
        return place;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
}
