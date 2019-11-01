package ua.delivery.model.entity;

import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.util.Role;

import java.util.Date;
import java.util.Objects;

public class UserEntity {
    private final Long id;
    private final UserCredentialsEntity userCredentials;
    private final String name;
    private final String surname;
    private final Date dateOfBirth;
    private final Role role;

    public UserEntity(UserEntityBuilder userEntityBuilder) {
        this.id = userEntityBuilder.id;
        this.userCredentials = userEntityBuilder.userCredentials;
        this.name = userEntityBuilder.name;
        this.surname = userEntityBuilder.surname;
        this.dateOfBirth = userEntityBuilder.dateOfBirth;
        this.role = userEntityBuilder.role;
    }

    public static UserEntityBuilder builder() {
        return new UserEntityBuilder();
    }

    public Long getId() {
        return id;
    }

    public UserCredentialsEntity getUserCredentials() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return getId().equals(that.getId()) &&
                getUserCredentials().equals(that.getUserCredentials()) &&
                getName().equals(that.getName()) &&
                getSurname().equals(that.getSurname()) &&
                getDateOfBirth().equals(that.getDateOfBirth()) &&
                getRole() == that.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserCredentials(), getName(), getSurname(), getDateOfBirth(), getRole());
    }

    public static class UserEntityBuilder {
        private Long id;
        private UserCredentialsEntity userCredentials;
        private String name;
        private String surname;
        private Date dateOfBirth;
        private Role role;

        public UserEntityBuilder() {
        }

        public UserEntity build() {
            return new UserEntity(this);
        }

        public UserEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserEntityBuilder withUserCredentials(UserCredentialsEntity userCredentials) {
            this.userCredentials = userCredentials;
            return this;
        }

        public UserEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserEntityBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserEntityBuilder withDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserEntityBuilder withRole(Role role) {
            this.role = role;
            return this;
        }

    }
}
