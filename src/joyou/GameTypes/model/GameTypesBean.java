package joyou.GameTypes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GameTypes")
public class GameTypesBean {
	
	Integer gametypeId;
	String gametypeName;
	
	@Id
	@Column(name="gametypeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getGametypeId() {
		return gametypeId;
	}
	
	public void setGametypeId(Integer gametypeId) {
		this.gametypeId = gametypeId;
	}
	
	@Column(name="gametypename")
	public String getGametypeName() {
		return gametypeName;
	}
	
	public void setGametypeName(String gametypeName) {
		this.gametypeName = gametypeName;
	}
	
}
