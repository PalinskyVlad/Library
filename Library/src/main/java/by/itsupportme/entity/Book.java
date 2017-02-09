package by.itsupportme.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends BaseEntity {

	@Column(name = "name", length = 64)
	private String name;
	
	@Column(name = "in_library")
	private boolean inLibrary;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
	private Set<Author> authors = new HashSet<>();

	@OneToMany(mappedBy = "book")
	private Set<TemporaryPossession> temporaryPossessions = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInLibrary() {
		return inLibrary;
	}

	public void setInLibrary(boolean inLibrary) {
		this.inLibrary = inLibrary;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (inLibrary != other.inLibrary)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "Book [name=" + name + ", inLibrary=" + inLibrary;
	}
	
}
