package managed;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoCuentas;
import daos.DaoMovimientos;
import model.Cuenta;
import model.Movimiento;
@ManagedBean
@RequestScoped
public class MovimientosBeans {
	private int cuentaSel;
	private Date fechaini;
	private Date fechafin;
	private List<Cuenta> cuentas;
	private List<Movimiento> movimientos;
	@EJB
	DaoMovimientos daoMovimientos;
	@EJB
	DaoCuentas daoCuentas;
	@PostConstruct
	public void inicio() {
		cuentas=daoCuentas.findAllCuentas();
	}
	
	public int getCuentaSel() {
		return cuentaSel;
	}
	public void setCuentaSel(int cuentaSel) {
		this.cuentaSel = cuentaSel;
	}
	public Date getFechaini() {
		return fechaini;
	}
	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
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
	
	//controlador de acción
	public void recuperarMovimientos() {
		movimientos=daoMovimientos.findMovimientosByCuenta(cuentaSel, fechaini, fechafin);
	}
	
	
}
