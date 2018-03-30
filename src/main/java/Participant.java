public class Participant {
    private String startCity;
    private String lastCity;
    private int batterySize;
    private int lowSpeedPerformance;
    private int highSpeedPerformance;
    private double chargeOf;

    public Participant(String startCity, int batterySize, int lowSpeedPerformance, int highSpeedPerformance) {
        this.startCity = startCity;
        this.batterySize = batterySize;
        this.lowSpeedPerformance = lowSpeedPerformance;
        this.highSpeedPerformance = highSpeedPerformance;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public int getLowSpeedPerformance() {
        return lowSpeedPerformance;
    }

    public void setLowSpeedPerformance(int lowSpeedPerformance) {
        this.lowSpeedPerformance = lowSpeedPerformance;
    }

    public int getHighSpeedPerformance() {
        return highSpeedPerformance;
    }

    public void setHighSpeedPerformance(int highSpeedPerformance) {
        this.highSpeedPerformance = highSpeedPerformance;
    }

    public String getLastCity() {
        return lastCity;
    }

    public void setLastCity(String lastCity) {
        this.lastCity = lastCity;
    }

    public double getChargeOf() {
        return chargeOf;
    }

    public void setChargeOf(double chargeOf) {
        this.chargeOf = chargeOf;
    }
}
