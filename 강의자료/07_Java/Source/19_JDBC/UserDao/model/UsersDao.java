package daoex.model;

import java.util.List;

public interface UsersDao {
	public int insert(Users params);
	
	public int delete(String params);
	
	public int update(Users params);
	
	public Users selectOne(String params);
	
	public List<Users> select();
}
