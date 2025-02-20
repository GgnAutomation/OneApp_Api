package pojo_Update_Customer_Details;

public class Update_Customer_Details_Data_Input {

	public String customerIdentifier;
	public String birthDate;
	public String firstName;
	public String lastName;
	public String gender;
	public String email;
	public String bloodGroup;
	public String addressLine1;
	public String city;
	public String state;
	public String pincode;
	public int isExisting;

	public Update_Customer_Details_Data_Input(String customerIdentifier, String birthDate, String firstName,
			String lastName, String gender, String email, String bloodGroup, String addressLine1, String city,
			String state, String pincode, int isExisting) {
		this.customerIdentifier = customerIdentifier;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.bloodGroup = bloodGroup;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.isExisting = isExisting;
	}

	public Update_Customer_Details_Data_Input() {
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getIsExisting() {
		return isExisting;
	}

	public void setIsExisting(int isExisting) {
		this.isExisting = isExisting;
	}

}
