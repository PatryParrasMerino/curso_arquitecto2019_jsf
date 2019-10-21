package validadores;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "vPassword")
public class ValidadorPassword implements Validator {
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String valor=(String)arg2;	
		UIInput pass2 =(UIInput)arg1.findComponent("password"); //para conseguir la contraseña original desde el UIComponent
		String passwordRepetida=(String)pass2.getValue();
		if(!valor.equals(passwordRepetida)) {
			ResourceBundle res=arg0.getApplication().getResourceBundle(arg0, "m");
			throw new ValidatorException(new FacesMessage(res.getString("error.password")));
		}
	}

}
