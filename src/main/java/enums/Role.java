package enums;

import java.util.List;

public enum Role {
    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    COACH("COACH"),
    ATHLETE("ATHLETE"),;
    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static List<String> getRoleNames() {
        return List.of(ADMIN.getName(), MANAGER.getName(), COACH.getName(), ATHLETE.getName());
    }

}
