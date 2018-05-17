package pl.mmprogr.library.model.user;

import org.springframework.stereotype.Component;

@Component
public class UserBuilder {
	public String firstname;
	public String lastname;

	public UserBuilder withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public UserBuilder withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public User build(){
		return new User(this);
	}
}
