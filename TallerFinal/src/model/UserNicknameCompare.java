package model;

import java.util.Comparator;

public class UserNicknameCompare implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o1.getNickname().compareTo(o2.getNickname());
	}
	
	

}
