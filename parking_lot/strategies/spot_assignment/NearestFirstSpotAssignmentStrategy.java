package strategies.spot_assignment;

import Models.*;
import exceptions.NoSpotAvailableException;

public class NearestFirstSpotAssignmentStrategy implements AssignSpotStrategy{

    @Override
    public Spot assignSpot(VehicleType vehicleType, ParkingLot parkingLot) throws NoSpotAvailableException {
        for (Floor floor : parkingLot.getFloors()) {
            if(floor.getFloorStatus().equals(FloorStatus.OPERATIONAL)) {
                for (Section section : floor.getSections()) {
                    for (Spot spot : section.getSpots()) {
                         if(spot.getVehicleType().equals(vehicleType) && spot.getStatus().equals(SpotStatus.UNOCCUPIED)){
                             spot.setStatus(SpotStatus.OCCUPIED);
                             return  spot;
                         }
                    }
                }
            }
        }
        throw new NoSpotAvailableException("No spots available for " + vehicleType);
    }
}
