package classic;

import java.io.Serializable;
import java.util.Set;


public interface Poll extends Serializable {

	enum Status {INITIALIZED, OPEN, FINALIZED};
	
	void addAMember(String member);

	void setMembers(Set<String> members);
	
	void setOpen();
	
	void setFinalized();
	
	void addResponse(Response response);
	
	String getTitle();

	Status getStatus();
	
	Set<String> getMembers();

}