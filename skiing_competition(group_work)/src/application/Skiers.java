package landskidstavling;

import java.io.Serializable;

public class Skiers implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private String lastCompetitionTime;
	private String lapTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastCompetitionTime() {
		return lastCompetitionTime;
	}

	public void setLastCompetitionTime(String lastCompetitionTime) {
		this.lastCompetitionTime = lastCompetitionTime;
	}

	public String getLapTime() {
		return lapTime;
	}

	public void setLapTime(String lapTime) {
		this.lapTime = lapTime;
	}
	
}
