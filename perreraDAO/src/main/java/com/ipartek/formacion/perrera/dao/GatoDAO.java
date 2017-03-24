package com.ipartek.formacion.perrera.dao;

import java.util.List;

import com.ipartek.formacion.perrera.pojo.Gato;

public interface GatoDAO {

	List<Gato> getAll(String order, String campo);

	Gato getById(long idGato);

	boolean delete(long idGato);

	boolean update(Gato gato);

	boolean insert(Gato gato);
}
