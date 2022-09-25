package modelo;



/**
 * Crea valores fijos de las especialidades disponibles dentro del hostipal "El paciente feliz" 
 * 
 * Creado el 29 de Agosto del 2022, 16:47 horas
 * @author Marlon Jair Azua Barrera
 * @version POO - 2022
 */
public enum Especialidad{
	oftamologo("Oftamólogo"), neurologo("Neurólogo"), dermatologo("Dermatólogo"), traumatologo("Traumatólogo"), ginecologo("Ginecólogo"), urologo("Urólogo"), cardiologo("Cardiólogo"), general("General");

	private String tipoEspecialidad;
        
	private Especialidad(String tipoEspecialidad) {
		this.tipoEspecialidad = tipoEspecialidad;
	}

	public String getEspecialidad(){
		return tipoEspecialidad; 
	}
	public void setEspecialidad(String tipoEspecialidad){
		this.tipoEspecialidad= tipoEspecialidad;
	}

    public void setTipoEspecialidad(String tipoEspecialidad) {
        this.tipoEspecialidad = tipoEspecialidad;
    }
        
}
