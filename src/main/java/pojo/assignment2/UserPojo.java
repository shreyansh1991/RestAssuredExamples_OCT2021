package pojo.assignment2;

public class UserPojo {
    private String name;
    private String username;
    private String email;
    private Address address;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public UserPojo setName(String name) {
        this.name = name;
        return this;
    }

    public UserPojo setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserPojo setEmail(String email) {
        this.email = email;
        return this;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
