package enums;

public enum Users {

    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String name;
    public String password;
    public String displayName;

    Users(String name, String password, String displayName) {
        this.name = name;
        this.password = password;
        this.displayName = displayName;
    }

    public static Users toUser(String userStr) {
        for (Users user : Users.values()) {
            if (user.displayName.equals(userStr.toUpperCase())) {
                return user;
            }
        }
        throw new IllegalArgumentException("User was not found");
    }
}
