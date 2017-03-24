package com.ipartek.formacion.perrera.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Session;

import com.ipartek.formacion.perrera.pojo.Gato;
import com.ipartek.formacion.perrera.util.HibernateUtil;

public class GatoDAOImpl implements GatoDAO {

	// instanciar unica para 'patron singleton'
	private static GatoDAOImpl INSTANCE = null;

	// constructor privado para que no se pueda instanciar esta clase
	private GatoDAOImpl() {
		super();
	}

	// unico metodo para crear un objeto de esta Clase
	public synchronized static GatoDAOImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GatoDAOImpl();
		}
		return INSTANCE;
	}

	/**
	 * Función que devuelve una lista de gatos
	 * 
	 * @param order
	 *            Modo de ordenacion de la lista.<br>
	 *            Posibles valores asc/desc
	 * @param campo
	 *            Campo por el que se va a ordenar. <br>
	 *            Posibles valores id/nombre/raza
	 * @return List<Gato>
	 */
	@Override
	public List<Gato> getAll(String order, String campo) {

		// inicializamos lista como un ArrayList de objetos Gato
		ArrayList<Gato> lista = new ArrayList<Gato>();

		// obtenemos la session
		Session s = (Session) HibernateUtil.getSession();

		try {

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;
	}

	@Override
	public Gato getById(long idGato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long idGato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Gato gato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Gato gato) {
		// TODO Auto-generated method stub
		return false;
	}

}
