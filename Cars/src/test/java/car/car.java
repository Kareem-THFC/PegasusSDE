package car;

public class car {
    private Long id;
    private String Model;
    private int production_year;
    private String brand;
    private String color;
    private int dailyRate;

    public car(Long id, String model, int production_year, String brand, String color, int dailyRate) {
        this.id = id;
        Model = model;
        this.production_year = production_year;
        this.brand = brand;
        this.color = color;
        this.dailyRate = dailyRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getProduction_year() {
        return production_year;
    }

    public void setProduction_year(int production_year) {
        this.production_year = production_year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", Model='" + Model + '\'' +
                ", production_year=" + production_year +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", dailyRate=" + dailyRate +
                '}';
    }




}

