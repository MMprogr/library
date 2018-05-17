package pl.mmprogr.library.model.user;

public class User {
	private final String firstname;
	private final String lastname;

	public User(UserBuilder userBuilder) {
		this.firstname = userBuilder.firstname;
		this.lastname = userBuilder.lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
}
