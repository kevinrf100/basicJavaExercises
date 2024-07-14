public class AccountStatus {
    private final boolean active;
    private String description;

    public AccountStatus(boolean active) {
        this.active = active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "--AccountStatus--" + '\n' +
                "active: " + active + '\n' +
                "Reason: " + description;
    }
}
