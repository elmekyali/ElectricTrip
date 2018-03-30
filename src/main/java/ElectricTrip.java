import parsers.DefaultParser;
import parsers.Parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ElectricTrip {

    private List<TripPart> tripParts;
    private List<Participant> participants;
    private Parser parser = new DefaultParser();
    private Participant currentParticipant;
    private int startCityIndex;

    public ElectricTrip(String trip) {

        tripParts    = new LinkedList<TripPart>();
        participants = new ArrayList<Participant>();
        String[] parts = parser.parseTrip(trip , "-");

        int index = 0;

        while (index < parts.length)
        {
            String[] cityAndCharge  = parser.parseTripPart(parts[index++] , ":");
            String city             = cityAndCharge[0];
            int charge              = Integer.parseInt(cityAndCharge[1]);
            int distance            = index == parts.length ? 0 : Integer.parseInt(parts[index++]);

            TripPart tripPart = new TripPart(city , charge , distance);
            tripParts.add(tripPart);

        }
    }

    public int startTripIn(String startCity, int batterySize, int lowSpeedPerformance, int highSpeedPerformance) {
        Participant participant = new Participant(startCity , batterySize , lowSpeedPerformance , highSpeedPerformance);
        participant.setChargeOf(batterySize);
        participants.add(participant);
        return participants.size() - 1;
    }

    public void go(int participantId) {
        calculDistanceAndCharge(participantId , "LowSpeed");
    }

    public String locationOf(int participantId) {
        currentParticipant = participants.get(participantId);
        currentParticipant.setStartCity(currentParticipant.getLastCity());
        return currentParticipant.getLastCity();
    }

    public String chargeOf(int participantId) {
        currentParticipant = participants.get(participantId);
        return (int)(((currentParticipant.getChargeOf() * 100) / (double)currentParticipant.getBatterySize()) + 0.5) + "%";
    }

    public void sprint(int participantId) {
        calculDistanceAndCharge(participantId , "HighSpeed");
    }

    public void charge(int participantId, int hoursOfCharge) {
        currentParticipant = participants.get(participantId);
        int startCity      = tripParts.indexOf(new TripPart(currentParticipant.getStartCity() , 0));
        if(tripParts.get(startCity).getCharge() > 0)
        {
            double newChargeOf = (tripParts.get(startCity).getCharge() * hoursOfCharge) + currentParticipant.getChargeOf();
            currentParticipant.setChargeOf(newChargeOf);
        }
    }

    public void calculDistanceAndCharge(int participantId , String type){

        currentParticipant = participants.get(participantId);
        startCityIndex     = tripParts.indexOf(new TripPart(currentParticipant.getStartCity() , 0));
        int maxDistance = 0;
        double factorPerformance = 0;
        if (type.equals("LowSpeed"))
        {
            factorPerformance = currentParticipant.getLowSpeedPerformance();
            maxDistance = (int) (currentParticipant.getChargeOf() * factorPerformance);
        }
        else if (type.equals("HighSpeed"))
        {
            factorPerformance = currentParticipant.getHighSpeedPerformance();
            maxDistance = (int) (currentParticipant.getChargeOf() * factorPerformance);
        }

        int sumDistance = 0;
        for(int index = startCityIndex ; index < tripParts.size() ; index++)
        {
            int distance = tripParts.get(index).getDistance();
            sumDistance += distance;
            if(sumDistance <= maxDistance)
            {
                currentParticipant.setLastCity(tripParts.get(index).getCity());
                currentParticipant.setChargeOf(currentParticipant.getChargeOf() - (distance / factorPerformance) );
            }else{
                currentParticipant.setLastCity(tripParts.get(index).getCity());
                break;
            }
        }
    }
}
