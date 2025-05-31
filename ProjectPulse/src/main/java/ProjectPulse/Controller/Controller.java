package ProjectPulse.Controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ProjectPulse.Doa.Doa;
import ProjectPulse.Model.ApplyJob;
import ProjectPulse.Model.ApplyProject;
import ProjectPulse.Model.CPostJob;
import ProjectPulse.Model.Company;
import ProjectPulse.Model.Freelancer;
import ProjectPulse.Model.PProject;

@org.springframework.stereotype.Controller
public class Controller {
       
	@Autowired
	private Doa dd;
	@RequestMapping("/RegisterCompany")
	public String RegisterPage() {
		return "RegisterCompany";
	}
	@RequestMapping(path="/HaddleRegisterCompany",method = RequestMethod.POST)
	public String RegisterCompanyData(@ModelAttribute Company cy,@RequestParam(name="CFileName") MultipartFile fn) throws IOException {
		String FileName=fn.getOriginalFilename();
		String path = "C:\\Users\\Windows_10\\git\\repository2\\ProjectPulse\\src\\main\\webapp\\FolderForDesign\\ClientImage";
		File dir = new File(path);
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
		BufferedOutputStream Bf=new BufferedOutputStream(new FileOutputStream(path+"/"+FileName));
		byte b[]=fn.getBytes();
		Bf.write(b);
		Bf.close();
		cy.setCProfileFile(FileName);
		dd.RegisterCompany(cy);
		return "redirect:/LogInPage";
	}
	@RequestMapping("/LogInPage")
	public String LogInPage() {
		
		return "LoginCompany";
	}
	@RequestMapping(path="/LoginCompany",method = RequestMethod.POST)
	public String LoginCompany(@RequestParam("CEmail") String Email,@RequestParam("CPassword") String Pass,HttpSession Hs) {
		if(dd.FetchLoginData(Email,Pass).isEmpty()) {
		return "LoginCompany";
		}
		Hs.setAttribute("SessionData",Email);
		Hs.setAttribute("SessionCompany",dd.FetchLoginData(Email,Pass));
		return "redirect:/HomeCompany";
	}
	@RequestMapping("/HomeCompany")
	public String HomeCompany(HttpSession Hs,Model m) {
		String Session=(String) Hs.getAttribute("SessionData");
		@SuppressWarnings("unchecked")
		List<Company> Lc=(List<Company>) Hs.getAttribute("SessionCompany");
		if(Session==null) {
		return "LoginCompany";	
		}
		m.addAttribute("countfreelancer",dd.getcountfreelancer());
	    m.addAttribute("countjobs",dd.getcountjobs());
		m.addAttribute("countproject",dd.getcountproject());
	    m.addAttribute("countcompany",dd.getcountcompany());
		m.addAttribute("CompanyData",Lc);
		return "HomeCompany";
	}
	@RequestMapping("/LogoutCompany")
	public String LogoutComapny(HttpSession Hs) {
		Hs.invalidate();
		return "LoginCompany";
	}
	@RequestMapping("/profilec")
	public String profilec(HttpSession Hs,Model m) {
		List<Company> Lc=(List<Company>) Hs.getAttribute("SessionCompany");
		m.addAttribute("CompanyData",Lc);
		return "ProfileC";
	}
	
	@RequestMapping(path="/updateprofile", method = RequestMethod.POST)
	public String updateprofile(
	        @ModelAttribute Company cy,
	        @RequestParam(name="CPProfileFile") MultipartFile fn) throws IOException {
	   if(fn.isEmpty()==true) {
	  dd.UpdateWithProfileData(cy);
  }
  else {
		String FileName = fn.getOriginalFilename();
//	    String path ="C:\\ProjectPulseUpload\\FolderForDesign\\ClientImage";
	String path = "C:\\Users\\Windows_10\\git\\repository2\\ProjectPulse\\src\\main\\webapp\\FolderForDesign\\ClientImage";
	File dir = new File(path);
    if (!dir.exists()) {
        dir.mkdirs();
    }
	BufferedOutputStream Bf=new BufferedOutputStream(new FileOutputStream(path+"/"+FileName));
	byte b[]=fn.getBytes();
	Bf.write(b);
	Bf.close();
	cy.setCProfileFile(FileName);
	dd.UpdateData(cy);
  }
	    return "redirect:/LogInPage";
	}
	@RequestMapping("/PostJob")
	public String postjob(HttpSession Hs,Model m) {
		List<Company> Lc=(List<Company>) Hs.getAttribute("SessionCompany");
	m.addAttribute("CompanyData",Lc);
		return "PostJobCompany";
	}
	@RequestMapping(path="/PostJobdata")
	public String PostJobdata(@ModelAttribute CPostJob CPJ,Model m) {
		dd.InsertPostJob(CPJ);
		m.addAttribute("messaage","SuccessFully PostJob");
		return "PostJobCompany";
	}
	@RequestMapping("/PostProject")
	public String PostProject(HttpSession Hs,Model m) {
		List<Company> Lc=(List<Company>) Hs.getAttribute("SessionCompany");
		m.addAttribute("CompanyData",Lc);
		return "PostProject";
	}
	
	@RequestMapping(path="/PostProjectData",method =RequestMethod.POST)
	public String PostProjectData(@ModelAttribute PProject pp,
	        @RequestParam(name="projectfile") MultipartFile fn,Model m) throws IOException {
		String FileName=fn.getOriginalFilename();
		String path = "C:\\Users\\Windows_10\\git\\repository2\\ProjectPulse\\src\\main\\webapp\\FolderForDesign\\ClientImage";
		File dir = new File(path);
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
		BufferedOutputStream Bf=new BufferedOutputStream(new FileOutputStream(path+"/"+FileName));
		byte b[]=fn.getBytes();
		Bf.write(b);
		Bf.close();
		pp.setPFilePdf(FileName);
		dd.InsertPProject(pp);
		m.addAttribute("messaage","SuccessFully PostProject");
		return "PostProject";
	}
	@RequestMapping("/ViewCandinateApplication/{CName}")
	public String PostProject(@PathVariable String CName,Model m,HttpSession Hs) {
	    List<ApplyJob> Aj=dd.getViewCandinateApplication(CName);
		m.addAttribute("CandinateApplication",Aj);
		List<ApplyProject> Ap=dd.getViewProjectCandinateApplication(CName);
		m.addAttribute("ProjectApplication",Ap);
		List<Company> Lc=(List<Company>) Hs.getAttribute("SessionCompany");
		m.addAttribute("CompanyData",Lc);
		return "ViewCandinateApplication";
	}
	@RequestMapping("/UpdateStatus")
	public String UpdateStatus(@ModelAttribute ApplyJob aj,Model m) throws IOException {
	        dd.UpdateS(aj);
		m.addAttribute("MessageCompany","STATUS CHANGED");
		return "MessagePageCompany";
	}
	@RequestMapping("/UpdateStatusProject")
	public String UpdateStatusProject(@ModelAttribute ApplyProject ap,Model m) throws IOException {
	        dd.UpdateSProject(ap);
		m.addAttribute("MessageProject","STATUS CHANGED");
		return "MessagePageCompany";
	}
	@RequestMapping("/AcceptedApplication/{CName}")
	public String AcceptedApplication(@PathVariable String CName,Model m){
	        
	        m.addAttribute("getallapplicationdata",dd.getAcceptedData(CName));
	        m.addAttribute("getapplicationdataproject",dd.getAcceptedProjectData(CName));
		return "AcceptedApplication";
	}
	@RequestMapping("/RejectedCandidate/{CName}")
	public String RejectedCandidate(@PathVariable String CName,Model m) throws IOException {
		m.addAttribute("getallrejectedcandidatedata",dd.getRejectedData(CName));
		m.addAttribute("getallrejecteddata",dd.getRejectedProjectData(CName));
		return "RejectedCandidate";
	}
	@RequestMapping("/ManageJobProject/{CName}")
	public String ManageJobProject(@PathVariable String CName,Model m) throws IOException {
		m.addAttribute("JobData",dd.getJobData(CName));
		m.addAttribute("ProjectData",dd.getProjectProjectData(CName));
		return "ManageJobProject";
	}
	@RequestMapping("EditJob/{id}")
	public String EditJob(@PathVariable int id,Model m) throws IOException {
		m.addAttribute("jobdata",dd.getEditData(id));
		return "EditJobDetail";
	}
	@RequestMapping(path="UpdateJobData",method = RequestMethod.POST)
	public String UpdateJobData(@ModelAttribute CPostJob cpj,Model m) throws IOException {
		dd.getUpdateEditData(cpj);
		m.addAttribute("MessageUpdate","SuccessFully PostProject Update");
		return "MessagePageCompany";
	}
	@RequestMapping("Delete/{id}")
	public String DeleteJobData(@PathVariable int id,Model m) throws IOException {
		dd.getDeleteJobData(id);
		m.addAttribute("MessageDelete","SuccessFully PostProject Delete");
		return "redirect:/MessagePageCompany";
	}
	@RequestMapping("DeleteProject/{id}")
	public String DeleteProjectData(@PathVariable int id,Model m) throws IOException {
		dd.getDeleteProjectData(id);
		m.addAttribute("MessageProjectDelete","SuccessFully Project Delete");
		return "redirect:/MessagePageCompany";
	}
	@RequestMapping("ViewAllFreelancer")
	public String ViewAllFData(@ModelAttribute Freelancer fr,Model m) throws IOException {
		m.addAttribute("datafreelancer",dd.getViewAllFData(fr));
		return "ViewAllFreelancer";
	}
}
