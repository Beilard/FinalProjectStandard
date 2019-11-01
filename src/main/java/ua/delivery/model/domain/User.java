package ua.delivery.model.domain;

import ua.delivery.model.util.Role;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private final Long id;
    private final UserCredentials userCredentials;
    private final String name;
    private final String surname;
    private final Date dateOfBirth;
    private final Role role;
    private final List<Order> history;

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.userCredentials = userBuilder.userCredentials;
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.dateOfBirth = userBuilder.dateOfBirth;
        this.role = userBuilder.role;
        this.history = userBuilder.history;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public List<Order> getHistory() {
        return history;
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
                getDateOfBirth().equals(user.getDateOfBirth()) &&
                getRole() == user.getRole() &&
                Objects.equals(getHistory(), user.getHistory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserCredentials(), getName(), getSurname(), getDateOfBirth(), getRole(), getHistory());
    }

    public static class UserBuilder {
        private Long id;
        private UserCredentials userCredentials;
        private String name;
        private String surname;
        private Date dateOfBirth;
        private Role role;
        private List<Order> history;

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

        public UserBuilder withDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserBuilder withRole(Role role) {
            this.role = role;
            return this;
        }

        public UserBuilder withHistory(List<Order> history) {
            this.history = history;
            return this;
        }
    }
}
