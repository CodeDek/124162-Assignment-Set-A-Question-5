import java.util.List;

public class House {
    private String houseId;
    private List<Tenant> tenants;
    private double waterUsage;
    private double waterRate; // Rate per unit of water
    private double totalBill;

    public House(String houseId, List<Tenant> tenants, double waterRate) {
        this.houseId = houseId;
        this.tenants = tenants;
        this.waterRate = waterRate;
        this.waterUsage = 0;
        this.totalBill = 0;
    }

    public String getHouseId() {
        return houseId;
    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public double getWaterUsage() {
        return waterUsage;
    }

    public void addWaterUsage(double usage) {
        this.waterUsage += usage;
        updateBill();
    }

    public double getTotalBill() {
        return totalBill;
    }

    private void updateBill() {
        this.totalBill = this.waterUsage * this.waterRate;
    }

    @Override
    public String toString() {
        return "House{houseId='" + houseId + "', tenants=" + tenants + ", waterUsage=" + waterUsage + ", totalBill=" + totalBill + "}";
    }
}

