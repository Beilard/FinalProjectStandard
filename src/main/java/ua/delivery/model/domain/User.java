package ua.delivery.model.domain;

import java.util.Objects;

public class User {
    private final Long id;
    private final UserCredentials userCredentials;
    private final String name;
    private final String surname;
    private final Role role;

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.userCredentials = userBuilder.userCredentials;
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.role = userBuilder.role;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public Long getId() {
        return id;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return getUserCredentials().equals(user.getUserCredentials()) &&
                getName().equals(user.getName()) &&
                getSurname().equals(user.getSurname()) &&
                getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserCredentials(), getName(), getSurname(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCredentials=" + userCredentials +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                '}';
    }

    public static class UserBuilder {
        private Long id;
        private UserCredentials userCredentials;
        private String name;
        private String surname;
        private Role role;

        public UserBuilder() {
        }

        public User build() {
            return new User(this);
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withUserCredentials(UserCredentials userCredentials) {
            this.userCredentials = userCredentials;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserBuilder withRole(Role role) {
            this.role = role;
            return this;
        }
    }
}
