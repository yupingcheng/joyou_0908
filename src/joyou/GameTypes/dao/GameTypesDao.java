package joyou.GameTypes.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import joyou.GameTypes.model.GameTypesBean;

public class GameTypesDao {

	Session session;

	public GameTypesDao(Session session) {
		this.session = session;
	}
	
	public GameTypesDao() {
	}
	
	public int getGameTypeId(String name) {
		String hqlStr = "from GameTypes where gametypeName=name";
		Query<GameTypesBean> query = session.createQuery(hqlStr, GameTypesBean.class);
		
		query.setParameter("name", name);
		GameTypesBean result = query.uniqueResult();
		if(result!=null) {
		System.out.println("result id");
		}return result.getGametypeId();
		
	}
}
