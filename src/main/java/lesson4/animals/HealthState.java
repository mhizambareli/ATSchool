package lesson4.animals;

public enum HealthState {
    HEALTHY("Здоров"),
    UNHEALTHY("Нездоров");

    private String description;

    HealthState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
