package payLoads;

import pojoClass_ExternalLogin.Data_External_Login_Input_Pojo;
import pojoClass_ExternalLogin.Root_ExternalLogin_Input_Pojo;

public class External_Login_PayLoad {

	public Root_ExternalLogin_Input_Pojo addLoginDetails(String loginId, String loginType, String notificationType) {

		Data_External_Login_Input_Pojo data_input = new Data_External_Login_Input_Pojo(loginId, loginType,
				notificationType);
		Root_ExternalLogin_Input_Pojo root_Input = new Root_ExternalLogin_Input_Pojo(data_input);
		return root_Input;
	}

}
