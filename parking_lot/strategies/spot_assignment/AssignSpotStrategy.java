package strategies.spot_assignment;

import exceptions.NoSpotAvailableException;
import Models.ParkingLot;
import Models.Spot;
import Models.VehicleType;

public interface AssignSpotStrategy {
    public Spot assignSpot(VehicleType vehicleType, ParkingLot parkingLot) throws NoSpotAvailableException;
}
