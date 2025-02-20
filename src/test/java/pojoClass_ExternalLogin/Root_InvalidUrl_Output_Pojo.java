package pojoClass_ExternalLogin;

public class Root_InvalidUrl_Output_Pojo {

	public String statusCode;
	public String message;
	
	public Root_InvalidUrl_Output_Pojo() {
    }

    public Root_InvalidUrl_Output_Pojo(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
