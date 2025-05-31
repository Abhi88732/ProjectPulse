package ProjectPulse.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CompanyTable")
public class Company implements Serializable{
   
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="CId")
	 private int CId;
	
	 @Column(name="CName")
	 private String CName;
	@Column(name="CEmail")
	 private String CEmail;
	 
	 @Column(name="CNumber")
	 private String CNumber;
	 
	 @Column(name="CWebsite")
	 private String CWebsite;
	 
	 @Column(name="CPassword")
	 private String CPassword;
	 
	 @Column(name="CConfirmpassword")
	 private String CConfirmpassword;
 
	 @Column(name="CProfile")
	 private String CProfileFile;
	@Column(name="CAbout")
	 private String CAbout;
	public String getCProfileFile() {
		return CProfileFile;
	}

	public void setCProfileFile(String cProfileFile) {
		CProfileFile = cProfileFile;
	}
	public String getCAbout() {
		return CAbout;
	}

	public void setCAbout(String cAbout) {
		CAbout = cAbout;
	}
	public int getCId() {
		return CId;
	}

	public String getCEmail() {
		return CEmail;
	}

	public String getCNumber() {
		return CNumber;
	}

	public String getCWebsite() {
		return CWebsite;
	}

	public String getCPassword() {
		return CPassword;
	}

	public String getCConfirmpassword() {
		return CConfirmpassword;
	}

	public void setCId(int cId) {
		CId = cId;
	}

	public void setCEmail(String cEmail) {
		CEmail = cEmail;
	}

	public void setCNumber(String cNumber) {
		CNumber = cNumber;
	}

	public void setCWebsite(String cWebsite) {
		CWebsite = cWebsite;
	}

	public void setCPassword(String cPassword) {
		CPassword = cPassword;
	}

	public void setCConfirmpassword(String cConfirmpassword) {
		CConfirmpassword = cConfirmpassword;
	}
	
    public String getCName() {
			return CName;
		}
		public void setCName(String cName) {
			CName = cName;
		}
 
	 
	 
	 
	 
	 
}
