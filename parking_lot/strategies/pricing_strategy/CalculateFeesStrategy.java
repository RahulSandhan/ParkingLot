package strategies.pricing_strategy;

import Models.VehicleType;

import java.util.Date;

public interface CalculateFeesStrategy {
    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType);
}
