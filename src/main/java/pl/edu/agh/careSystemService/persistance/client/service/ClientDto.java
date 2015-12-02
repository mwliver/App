package pl.edu.agh.careSystemService.persistance.client.service;

public class ClientDto {
	
	private String name;
	private String surname;
	private Long id;

	public ClientDto(String name, String surname, Long id) {
		this.setName(name);
		this.setSurname(surname);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
