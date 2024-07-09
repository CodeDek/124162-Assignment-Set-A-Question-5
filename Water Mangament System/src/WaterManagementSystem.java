import java.util.*;

public class WaterManagementSystem {
    private Queue<String> requestsQueue;
    private Map<String, House> houses;

    public WaterManagementSystem() {
        requestsQueue = new LinkedList<>();
        houses = new HashMap<>();
    }

    public void addHouse(House house) {
        houses.put(house.getHouseId(), house);
    }

    public void addRequest(String request) {
        requestsQueue.add(request);
    }

    public void processRequests() {
        while (!requestsQueue.isEmpty()) {
            String request = requestsQueue.poll();
            processRequest(request);
        }
    }

    private void processRequest(String request) {
        String[] parts = request.split(" ");
        String houseId = parts[0];
        double usage = Double.parseDouble(parts[1]);

        House house = houses.get(houseId);
        if (house != null) {
            house.addWaterUsage(usage);
            System.out.println("Processed request for house " + houseId + ": added " + usage + " units of water.");
        } else {
            System.out.println("House " + houseId + " not found.");
        }
    }

    public void printHouseDetails() {
        for (House house : houses.values()) {
            System.out.println(house);
        }
    }

    public static void main(String[] args) {
        WaterManagementSystem system = new WaterManagementSystem();

        // Create tenants
        List<Tenant> tenants1 = Arrays.asList(new Tenant("John Doe", 30), new Tenant("Jane Doe", 28));
        List<Tenant> tenants2 = Arrays.asList(new Tenant("Alice Smith", 25), new Tenant("Bob Brown", 27));

        // Create houses
        House house1 = new House("H1", tenants1, 2.0); // $2.0 per unit of water
        House house2 = new House("H2", tenants2, 2.5); // $2.5 per unit of water

        // Add houses to the system
        system.addHouse(house1);
        system.addHouse(house2);

        // Add water usage requests
        system.addRequest("H1 100"); // House H1 used 100 units of water
        system.addRequest("H2 150"); // House H2 used 150 units of water
        system.addRequest("H1 50");  // House H1 used 50 more units of water

        // Process the requests
        system.processRequests();

        // Print details of houses
        system.printHouseDetails();
    }
}

