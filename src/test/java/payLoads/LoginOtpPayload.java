package payLoads;

import pojo_External_Login_Otp.Verify_Otp_Tc2_Data_Input_Pojo;
import pojo_External_Login_Otp.Verify_Otp_Tc2_Root_Input_Pojo;

public class LoginOtpPayload {

	public Verify_Otp_Tc2_Root_Input_Pojo addDetails(String loginId, String otp, String isdCode, String deviceType,
			String osVersion, String appVersion, String deviceModel, String fireBaseToken) {

		Verify_Otp_Tc2_Data_Input_Pojo data_Input_Pojo = new Verify_Otp_Tc2_Data_Input_Pojo(loginId, otp, isdCode,
				deviceType, osVersion, appVersion, deviceModel, fireBaseToken);
		Verify_Otp_Tc2_Root_Input_Pojo root_Input_Pojo = new Verify_Otp_Tc2_Root_Input_Pojo(data_Input_Pojo);
		return root_Input_Pojo;

	}
}
