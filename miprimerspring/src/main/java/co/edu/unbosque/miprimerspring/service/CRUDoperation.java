package co.edu.unbosque.miprimerspring.service;

import java.util.List;

public interface CRUDoperation <T> {
	
	public int create(T data);
	public List<T> getAll(); 
	public int delateById(Long id);
	public int updateById(Long id, T data);
	public long count();
	public boolean exist(Long id);
}
