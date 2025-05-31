package ProjectPulse.Model;

import javax.persistence.*;

@Entity
@Table(name="ApplyProjectTable")
public class ApplyProject {
     
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="APId")
     private int APId;
	 @Column(name="APTitle")
	 private String APTitle;
	 @Column(name="APName")
	 private String APName;
	 @Column(name="APEmail")
	 private String APEmail;
	 @Column(name="APCEmail")
	 private String APCEmail;
	 @Column(name="APCName")
	 private String APCName;
	 @Column(name="APResume")
	 private String APResume;
	 @Column(name="APStatus")
	 private String APStatus;
	 
	public String getAPStatus() {
		return APStatus;
	}
	public void setAPStatus(String aPStatus) {
		APStatus = aPStatus;
	}
	public int getAPId() {
		return APId;
	}
	public String getAPTitle() {
		return APTitle;
	}
	public String getAPName() {
		return APName;
	}
	public String getAPEmail() {
		return APEmail;
	}
	public String getAPCEmail() {
		return APCEmail;
	}
	public String getAPCName() {
		return APCName;
	}
	public String getAPResume() {
		return APResume;
	}
	public void setAPId(int aPId) {
		APId = aPId;
	}
	public void setAPTitle(String aPTitle) {
		APTitle = aPTitle;
	}
	public void setAPName(String aPName) {
		APName = aPName;
	}
	public void setAPEmail(String aPEmail) {
		APEmail = aPEmail;
	}
	public void setAPCEmail(String aPCEmail) {
		APCEmail = aPCEmail;
	}
	public void setAPCName(String aPCName) {
		APCName = aPCName;
	}
	public void setAPResume(String aPResume) {
		APResume = aPResume;
	}
	 
	 
}
