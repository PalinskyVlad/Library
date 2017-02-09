package by.itsupportme.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reader")
public class Reader extends User{
	
	@Column(name = "first_name", length = 20)
	private String firstName;
	
	@Column(name = "last_name", length = 20)
	private String lastName;
	
	@OneToMany(mappedBy = "reader")
	private Set<TemporaryPossession> temporaryPossessions = new HashSet<>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<TemporaryPossession> getTemporaryPossessions() {
		return temporaryPossessions;
	}

	public void setTemporaryPossessions(Set<TemporaryPossession> temporaryPossessions) {
		this.temporaryPossessions = temporaryPossessions;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reader other = (Reader) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (temporaryPossessions == null) {
			if (other.temporaryPossessions != null)
				return false;
		} else if (!temporaryPossessions.equals(other.temporaryPossessions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reader [firstName=" + firstName + ", lastName=" + lastName + ", temporaryPossessions="
				+ temporaryPossessions + "]";
	}
	
}
