package ProjectPulse.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ComPostJob")
public class CPostJob implements Serializable{
	
      
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="PJId")
	 private int PJId;
	 @Column(name="PJName")
	 private String PJName;
	 @Column(name="PJEmail")
	 private String PJEmail;
	 @Column(name="PJDescription")
	 private String PJDescription;
	 @Column(name="PJTitle")
	 private String PJTitle;
	 @Column(name="PJSkills")
	 private String PJSkills;
	 @Column(name="PJSalary")
	 private String PJSalary;
	 @Column(name="PJRole")
	 private String PJRole;
	 @ManyToOne
	 @JoinColumn(name = "PJName", referencedColumnName = "CName", insertable = false, updatable = false)
	 private Company company;
	public int getPJId() {
		return PJId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getPJName() {
		return PJName;
	}
	public String getPJEmail() {
		return PJEmail;
	}
	public String getPJDescription() {
		return PJDescription;
	}
	public String getPJTitle() {
		return PJTitle;
	}
	public String getPJSkills() {
		return PJSkills;
	}
	public String getPJSalary() {
		return PJSalary;
	}
	public String getPJRole() {
		return PJRole;
	}
	public void setPJId(int pJId) {
		PJId = pJId;
	}
	public void setPJName(String pJName) {
		PJName = pJName;
	}
	public void setPJEmail(String pJEmail) {
		PJEmail = pJEmail;
	}
	public void setPJDescription(String pJDescription) {
		PJDescription = pJDescription;
	}
	public void setPJTitle(String pJTitle) {
		PJTitle = pJTitle;
	}
	public void setPJSkills(String pJSkills) {
		PJSkills = pJSkills;
	}
	public void setPJSalary(String pJSalary) {
		PJSalary = pJSalary;
	}
	public void setPJRole(String pJRole) {
		PJRole = pJRole;
	}
	 
	
}
