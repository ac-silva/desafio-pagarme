package PagarMe.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Address.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Address {
	@JsonProperty("id")
	private long id;
	@JsonProperty("street")
	private String street;
	@JsonProperty("complementary")
	private String complementary;
	@JsonProperty("street_number")
	private String streetNumber;
	@JsonProperty("neighborhood")
	private String neighborhood;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("country")
	private String country;
	@JsonProperty("zipcode")
	private String zipcode;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets the street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Gets the complementary.
	 *
	 * @return the complementary
	 */
	public String getComplementary() {
		return complementary;
	}
	
	/**
	 * Sets the complementary.
	 *
	 * @param complementary the new complementary
	 */
	public void setComplementary(String complementary) {
		this.complementary = complementary;
	}
	
	/**
	 * Gets the street number.
	 *
	 * @return the street number
	 */
	public String getStreetNumber() {
		return streetNumber;
	}
	
	/**
	 * Sets the street number.
	 *
	 * @param streetNumber the new street number
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	/**
	 * Gets the neighborhood.
	 *
	 * @return the neighborhood
	 */
	public String getNeighborhood() {
		return neighborhood;
	}
	
	/**
	 * Sets the neighborhood.
	 *
	 * @param neighborhood the new neighborhood
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
