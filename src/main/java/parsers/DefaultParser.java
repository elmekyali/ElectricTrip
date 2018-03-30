package parsers;


public class DefaultParser implements Parser {


    public String[] parseTrip(String trip, String separator) {
        return trip.split(separator);
    }

    public String[] parseTripPart(String cityAndCharge, String separator) {
        String[] parts = new String[2];
        String[] partsC = cityAndCharge.split(separator);
        parts[0] = partsC[0];
        if(partsC.length == 1) parts[1] = "0";
        else parts[1] = partsC[1];
        return parts;
    }
}
