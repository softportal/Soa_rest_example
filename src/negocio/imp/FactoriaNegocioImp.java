package negocio.imp;

import negocio.DAOLocalidad;
import negocio.FactoriaNegocio;
import negocio.localidad.SALocalidad;
import negocio.localidad.imp.SALocalidadImp;

public class FactoriaNegocioImp extends FactoriaNegocio {

	@Override
	public DAOLocalidad generaDAOLocalidad() {
		// TODO Auto-generated method stub
		return new DAOLocalidadImp();
	}
	
	public SALocalidad generaSALocalidad() {

		return new SALocalidadImp();
	}

}
