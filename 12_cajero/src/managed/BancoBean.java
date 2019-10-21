package managed;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoCuentas;
import daos.DaoMovimientos;
import model.Cuenta;
import model.Movimiento;

@ManagedBean
@RequestScoped
public class BancoBean {
	
	
	List<Cuenta> cuentas;
	List<Movimiento> movimientos;
	private Date fechaIni;
	private Date fechaFin;
	private String cuenta;
	
	
	@EJB
	DaoCuentas daoCuentas;
	
	@EJB
	DaoMovimientos daoMovimientos;
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
