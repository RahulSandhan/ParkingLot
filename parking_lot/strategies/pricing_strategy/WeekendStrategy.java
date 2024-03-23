package strategies.pricing_strategy;

import Models.Slab;
import Models.VehicleType;
import repositories.SlabRepository;
import utils.DateTimeUtils;

import java.util.Date;
import java.util.List;

public class WeekendStrategy implements CalculateFeesStrategy{

    private SlabRepository slabRepository;

    public WeekendStrategy(SlabRepository slabRepository) {
        this.slabRepository = slabRepository;
    }

    @Override
    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType) {
        // We should go via slab service
        List<Slab> slabs = this.slabRepository.getSlabsByVehicleType(vehicleType);
        int hours = DateTimeUtils.calcHours(entryTime, exitTime);
        double totalAmount = 0;
        for(Slab slab: slabs){
            if(hours >= slab.getStartHour() && slab.getEndHour() != -1){
                if(hours >= slab.getEndHour()){
                    totalAmount += (slab.getEndHour() - slab.getStartHour()) * slab.getPricePerHour();
                }
                else {
                    totalAmount += (hours - slab.getStartHour()) * slab.getPricePerHour();
                }
            } else if(slab.getEndHour() == -1){
                totalAmount += (hours - slab.getEndHour()) * slab.getPricePerHour();
            }
            else {
                break;
            }
        }

        return totalAmount;
    }
}
