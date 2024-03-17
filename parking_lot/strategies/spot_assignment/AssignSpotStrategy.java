package strategies.spot_assignment;

import exceptions.NoSpotAvailableException;
import parking_lot.models.ParkingLot;
import parking_lot.models.Spot;
import parking_lot.models.VehicleType;

public interface AssignSpotStrategy {
    public Spot assignSpot(VehicleType vehicleType, ParkingLot parkingLot) throws NoSpotAvailableException;
}
