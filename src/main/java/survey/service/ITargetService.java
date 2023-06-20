package survey.service;

import java.util.List;
import survey.entity.Targuet;

public interface ITargetService {
	
	public Targuet addTarget(Targuet t, int id);
	public List<Targuet> getAll();
	public Targuet get(int id);
	Boolean deleteTarguet(Targuet t);
	public void sendbywhatss(int id);
}
