package parsers;


import java.util.List;

public interface Parser {
    String[] parseTrip(String trip , String separator);
    String[] parseTripPart(String cityAndCharge , String separator);
}
