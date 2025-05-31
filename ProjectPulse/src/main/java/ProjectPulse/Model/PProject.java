package ProjectPulse.Model;

import javax.persistence.*;

@Entity
@Table(name="TPProject")
public class PProject {
       @Id
       @Column(name="PId")
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int PId;
       @Column(name="PDetails")
       private String PDetails;
       @Column(name="PTitle")
       private String PTitle;
       @Column(name="PFilePdf")
       private String PFilePdf;
       @Column(name="PSkills")
       private String PSkills;
       @Column(name="PBudget")
       private String PBudget;
       @Column(name="PEmail")
       private String PEmail;
       @Column(name="PName")
       private String PName;
	public int getPId() {
		return PId;
	}
	public String getPDetails() {
		return PDetails;
	}
	public String getPTitle() {
		return PTitle;
	}
	public String getPFilePdf() {
		return PFilePdf;
	}
	public String getPSkills() {
		return PSkills;
	}
	public String getPBudget() {
		return PBudget;
	}
	public String getPEmail() {
		return PEmail;
	}
	public String getPName() {
		return PName;
	}
	public void setPId(int pId) {
		PId = pId;
	}
	public void setPDetails(String pDetails) {
		PDetails = pDetails;
	}
	public void setPTitle(String pTitle) {
		PTitle = pTitle;
	}
	public void setPFilePdf(String pFilePdf) {
		PFilePdf = pFilePdf;
	}
	public void setPSkills(String pSkills) {
		PSkills = pSkills;
	}
	public void setPBudget(String pBudget) {
		PBudget = pBudget;
	}
	public void setPEmail(String pEmail) {
		PEmail = pEmail;
	}
	public void setPName(String pName) {
		PName = pName;
	}
       
}
