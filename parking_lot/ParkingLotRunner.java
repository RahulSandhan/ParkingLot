import controllers.TicketController;
import parking_lot.models.Gate;
import parking_lot.models.GateType;
import parking_lot.models.Operator;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.GateService;
import services.TicketService;
import services.TicketServiceImpl;
import strategies.spot_assignment.AssignSpotStrategy;
import strategies.spot_assignment.NearestFirstSpotAssignmentStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRunner {
    public static void main(String[] args) {

        Gate gate1 = new Gate();
        gate1.setGateType(GateType.ENTRY);
        gate1.setName("1A");
        gate1.setOperator(new Operator());
        gate1.setId(1);

        Map<Integer, Gate> gateMap = new HashMap<>(){{
            put(1,gate1);
        }};

        GateRepository gateRepository = new GateRepository(gateMap);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        GateService gateService = new GateService(gateRepository);
        AssignSpotStrategy assignSpotStrategy = new NearestFirstSpotAssignmentStrategy();
        TicketService ticketService = new TicketServiceImpl(gateService, vehicleRepository, assignSpotStrategy, parkingLotRepository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        //create objects of generateTicketRequestDto and call generateTicket method
    }
}
