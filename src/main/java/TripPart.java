public class TripPart {

    private String city;
    private int charge;
    private int distance;

    public TripPart(String city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    public TripPart(String city, int charge, int distance) {
        this.city = city;
        this.charge = charge;
        this.distance = distance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TripPart)) return false;

        TripPart tripPart = (TripPart) o;

        return city.equals(tripPart.city);
    }

    @Override
    public int hashCode() {
        return city.hashCode();
    }
}
