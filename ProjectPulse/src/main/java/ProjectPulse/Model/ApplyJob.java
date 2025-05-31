package ProjectPulse.Model;

import javax.persistence.*;

@Entity
@Table(name="ApplyJobTable")
public class ApplyJob {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="AJId")
	private int AJId;
	@Column(name="AJPosition")
	private String AJPosition;
	@Column(name="AJFName")
	private String AJFName;
	@Column(name="AJFEmail")
	private String AJFEmail;
	@Column(name="AJFResume")
	private String AJFResume;
	@Column(name="AJCName")
	private String AJCName;
	@Column(name="AJStatus")
	private String AJStatus;
	
	public String getAJStatus() {
		return AJStatus;
	}
	public void setAJStatus(String aJStatus) {
		AJStatus = aJStatus;
	}
	public int getAJId() {
		return AJId;
	}
	public String getAJPosition() {
		return AJPosition;
	}
	public String getAJFName() {
		return AJFName;
	}
	public String getAJFEmail() {
		return AJFEmail;
	}
	public String getAJFResume() {
		return AJFResume;
	}
	public String getAJCName() {
		return AJCName;
	}
	public void setAJId(int aJId) {
		AJId = aJId;
	}
	public void setAJPosition(String aJPosition) {
		AJPosition = aJPosition;
	}
	public void setAJFName(String aJFName) {
		AJFName = aJFName;
	}
	public void setAJFEmail(String aJFEmail) {
		AJFEmail = aJFEmail;
	}
	public void setAJFResume(String aJFResume) {
		AJFResume = aJFResume;
	}
	public void setAJCName(String aJCName) {
		AJCName = aJCName;
	}
	

}
