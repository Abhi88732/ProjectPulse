package ProjectPulse.Model;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FreelancerTable")
public class Freelancer implements Serializable {
    
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="FId") 	
	 private int FId;
	 @Column(name="FName")
	 private String FName;
	 @Column(name="FEmail")
	 private String FEmail;
	 @Column(name="FNumber")
	 private String FNumber;
	 @Column(name="FDate")
	 private Date FDate;
	 
	 @Column(name="FLinkdin")
	 private String FLinkdin;
	 @Column(name="FEducation")
	 private String FEducation;
	 @Column(name="FPProfile")
	 private String FPProfile;
	@Column(name="FCharge")
	 private String FCharge;
	 @Column(name="FGender")
	 private String FGender;
	 @Column(name="FSkills")
	 private String FSkills;
	 @Column(name="FPassword")
	 private String FPassword;
	 @Column(name="FCPassword")
	 private String FCPassword;
	 public String getFPProfile() {
			return FPProfile;
		}
		public void setFPProfile(String fPProfile) {
			FPProfile = fPProfile;
		}
	 public int getFId() {
		return FId;
	}
	public String getFName() {
		return FName;
	}
	public String getFEmail() {
		return FEmail;
	}
	public String getFNumber() {
		return FNumber;
	}
	public Date getFDate() {
		return FDate;
	}
	public String getFLinkdin() {
		return FLinkdin;
	}
	public String getFEducation() {
		return FEducation;
	}
	
	public String getFCharge() {
		return FCharge;
	}
	public String getFGender() {
		return FGender;
	}
	public String getFSkills() {
		return FSkills;
	}
	public String getFPassword() {
		return FPassword;
	}
	public String getFCPassword() {
		return FCPassword;
	}
	public void setFId(int fId) {
		FId = fId;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public void setFEmail(String fEmail) {
		FEmail = fEmail;
	}
	public void setFNumber(String fNumber) {
		FNumber = fNumber;
	}
	public void setFDate(Date fDate) {
		FDate = fDate;
	}
	public void setFLinkdin(String fLinkdin) {
		FLinkdin = fLinkdin;
	}
	public void setFEducation(String fEducation) {
		FEducation = fEducation;
	}
	
	public void setFCharge(String fCharge) {
		FCharge = fCharge;
	}
	public void setFGender(String fGender) {
		FGender = fGender;
	}
	public void setFSkills(String fSkills) {
		FSkills = fSkills;
	}
	public void setFPassword(String fPassword) {
		FPassword = fPassword;
	}
	public void setFCPassword(String fCPassword) {
		FCPassword = fCPassword;
	}
	 
	 
}
