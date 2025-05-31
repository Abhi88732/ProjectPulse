package ProjectPulse.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.security.MD5Encoder;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ProjectPulse.Doa.Doa;
import ProjectPulse.Doa.FreeDoa;
import ProjectPulse.Model.CPostJob;
import ProjectPulse.Model.Company;
import ProjectPulse.Model.Freelancer;
import ProjectPulse.Model.PProject;
import ProjectPulse.Model.ApplyJob;
import ProjectPulse.Model.ApplyProject;
import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class FreelancerController {

	@Autowired
	private FreeDoa FD;
	
	@RequestMapping("/RegisterFreelancer")
	public String RegisterFreelancer() {
		
		return "RegisterFreelancer";
	}
	
	@RequestMapping(path="LogInFreelancer",method = RequestMethod.GET)
	public String LogInFreelancer() {
		return "LogInFreelancer";
	}
	@RequestMapping(path="SaveFreelancerData",method = RequestMethod.POST)
	public String SaveFData(@ModelAttribute Freelancer Fr,@RequestParam(name="FPProfileFile") MultipartFile fn,Model m) throws IOException {
	
		if((Fr.getFPassword().compareTo(Fr.getFCPassword())==0 &&  FD.CheckEmail(Fr.getFEmail()).isEmpty())) {
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
		Fr.setFPProfile(FileName);
		FD.RegisterFreelancer(Fr);
		m.addAttribute("message","Successfully Register Freelancer");
		return "LogInFreelancer";
	  }
		m.addAttribute("messageError","Check Password and ConfirmPassword OR Email is already Exits");
		return "RegisterFreelancer";
	}
	@RequestMapping(path="/LogInFreelancer",method = RequestMethod.POST)
	public String LoginCompany(@RequestParam("FEmail") String Email,@RequestParam("FPassword") String Pass,HttpSession Hs) {
		if(FD.ReLoginData(Email, Pass).isEmpty()) {
		return "LogInFreelancer";
		}
		Hs.setAttribute("FreelancerSessionData",Email);
		Hs.setAttribute("FreelancerAllData",FD.ReLoginData(Email, Pass));
		return "redirect:/FreelancerHomeController";
	}
	@RequestMapping(path="/FreelancerHomeController")
	public String FreelancerHController(HttpSession Hs,Model m) {
        String session=(String)Hs.getAttribute("FreelancerSessionData"); 
        if(session==null) {
        	return "LogInFreelancer";
        }
        m.addAttribute("countfreelancer",FD.getcountfreelancer());
	    m.addAttribute("countjobs",FD.getcountjobs());
		m.addAttribute("countproject",FD.getcountproject());
	    m.addAttribute("countcompany",FD.getcountcompany());
        m.addAttribute("jobdata",FD.getjobdata()); 
        m.addAttribute("projectdata",FD.getApplyProjectData());
        List<Freelancer>  LF=(List<Freelancer>) Hs.getAttribute("FreelancerAllData");
		  m.addAttribute("FreelancerShowData",LF);
         return "FreelancerHomeController";
	}
	@RequestMapping(path="/FreelancerLogOut")
	public String FreelancerLogOut(HttpSession Hs) {
		Hs.invalidate();
		return "LogInFreelancer";
	}
	@RequestMapping(path="/ProfileF")
	public String MProfileF(HttpSession Hs,Model m) {
		List<Freelancer>  LF=(List<Freelancer>) Hs.getAttribute("FreelancerAllData");
		  m.addAttribute("FreelancerShowData",LF);
		return "ProfileF";
	}
	@RequestMapping(path="UpdateProfileF",method = RequestMethod.POST)
	public String MUpdateProfileF(@ModelAttribute Freelancer Fr,@RequestParam(name="FProfileFile") MultipartFile fn) throws IOException {
		if(fn.isEmpty()==true) {
			FD.UpdateWithOutProFreelancer(Fr);
		}else {
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
		Fr.setFPProfile(FileName);
		FD.UpdateProFreelancer(Fr);
		}	
		return "redirect:/LogInFreelancer";	
	}
    @RequestMapping("ExploreJobs")
    public String EPData(Model m){
    	 List<CPostJob> Cpj=FD.ShowAllData();
		    m.addAttribute("ShowCompanyData",Cpj);
    	return "ExploreJobs"; 
     }	
	 @RequestMapping("ExploreProject")	
	    public String FPData(Model m) {
		    List<PProject> Pp=FD.GetEProject();
		    m.addAttribute("ProjectData",Pp);
	    	return "ExploreProject";
	    }
	@RequestMapping(path="viewAndApply/{id}",method =RequestMethod.GET)
	public String ShowingJob(@PathVariable int id,Model model,HttpSession Hs,Model m) {
		List<CPostJob> Cpj=FD.getCPostJob(id);
		model.addAttribute("JobData",Cpj);
		   List<Freelancer>  LF=(List<Freelancer>) Hs.getAttribute("FreelancerAllData");
			  m.addAttribute("FreelancerShowData",LF);
		return "viewAndApply";
	}
	@RequestMapping(path="viewAndApplyProject/{id}",method =RequestMethod.GET)
	public String ShowingProject(@PathVariable int id,Model model,HttpSession Hs) {
		List<PProject> Cpj=FD.getPProject(id);
		model.addAttribute("ProjectData",Cpj);
		List<Freelancer>  LF=(List<Freelancer>) Hs.getAttribute("FreelancerAllData");
		  model.addAttribute("FreelancerShowData",LF);	
		return "ViewAndApplyProject";
	}
	@RequestMapping(path="ApplyForJob",method =RequestMethod.POST)
	public String ApplyJob(@ModelAttribute ApplyJob Fr,@RequestParam(name="ResumeFile") MultipartFile fn,Model m) throws IOException {
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
		Fr.setAJFResume(FileName);
		FD.SaveApplyJob(Fr);
		m.addAttribute("messagejob","SUCCESSFULLY SAVE");
		return "ExploreJobs";
	}
	@RequestMapping(path="ApplyForProject",method =RequestMethod.POST)
	public String ApplyProject(@ModelAttribute ApplyProject Fr,@RequestParam(name="resume") MultipartFile fn,Model m) throws IOException {
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
		Fr.setAPResume(FileName);
		FD.SaveApplyProject(Fr);
		m.addAttribute("messagejob","SUCCESSFULLY SAVE");
		return "ExploreProject";
	}
	@RequestMapping("MyApplication/{FEmail}")
	public String MyApplication(@PathVariable String FEmail,Model m) {
		List<ApplyJob> Aj=FD.getApplyJobData(FEmail);
		m.addAttribute("ApplyJobData", Aj);
		List<ApplyProject> Ap=FD.getApplyProjectData(FEmail);
		m.addAttribute("ApplyProjectData",Ap);
		return "MyApplication";
	}
	
}
