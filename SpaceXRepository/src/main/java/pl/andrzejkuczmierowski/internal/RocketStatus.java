package pl.andrzejkuczmierowski.internal;

public enum RocketStatus {
    ON_GROUND("On ground"),
    IN_SPACE("In space"),
    IN_REPAIR("In repair"),
    IN_BUILD("In build");
    private final String status;
    RocketStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
