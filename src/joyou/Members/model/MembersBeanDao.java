package joyou.Members.model;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("myMembersBeanDao")
public class MembersBeanDao {
	public Session session;

	public MembersBeanDao() {
	}

	public MembersBeanDao(Session session) {
		this.session = session;
	}

	public MembersBean insert(MembersBean mBean) {
		if (mBean != null) {
			session.save(mBean);
			return mBean;
		}
		return null;
	}

	public boolean checkCorrectAccPwd(String account, String password) {
		String hqlStr = "from MembersBean where memberAcc=:acc and memberPwd=:pwd";
		Query<MembersBean> query = session.createQuery(hqlStr, MembersBean.class);

		query.setParameter("acc", account);
		query.setParameter("pwd", password);

		// true if account and password are correct
		MembersBean resultAccount = query.uniqueResult();

		if (resultAccount != null) {
			return true;
		}

		return false;

	}

	public boolean checkDuplicateAcc(String account) {
//	public boolean checkDuplicateAcc(String account,String mail) {
		try {
			String hqlStr = "from MembersBean where memberAcc=:acc";
			// String hqlStr = "from MembersBean where memberAcc=:acc or membermail=:mail";
			Query<MembersBean> query = session.createQuery(hqlStr, MembersBean.class);

			query.setParameter("acc", account);

			MembersBean resultAccount = query.uniqueResult();

			if (resultAccount != null) {
				return true;
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}
}