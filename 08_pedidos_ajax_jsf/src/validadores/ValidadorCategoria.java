package validadores;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "vCat")
public class ValidadorCategoria implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String valor=(String)arg2;
		if(!valor.startsWith("9")) {//si no cumple el criterio
			//Obtenemos resourceBundle para acceder al mensaje de error
			ResourceBundle res=arg0.getApplication().getResourceBundle(arg0, "m");
			//throw new ValidatorException(new FacesMessage("Categoria no válida. Debe comenzar con un 9"));
			throw new ValidatorException(new FacesMessage(res.getString("error.categoria")));
		}
	}

}
