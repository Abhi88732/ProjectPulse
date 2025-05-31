package ProjectPulse.Doa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;         // ✅ Correct

import ProjectPulse.Model.ApplyJob;
import ProjectPulse.Model.ApplyProject;
import ProjectPulse.Model.CPostJob;
import ProjectPulse.Model.Company;
import ProjectPulse.Model.Freelancer;
import ProjectPulse.Model.PProject;

@Component
public class Doa {
    
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private SessionFactory Factory;
	
	@Transactional
	public void RegisterCompany(Company cy) {
		hibernateTemplate.save(cy);
	}
	@Transactional
	public  List<Company> FetchLoginData(String Email,String Pass) {
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM Company where CEmail = :email AND CPassword = :pass",Company.class);
		       Qy.setParameter("email",Email);
		       Qy.setParameter("pass",Pass);
		return Qy.getResultList();
	}
	@Transactional
	public void UpdateWithProfileData(Company cy) {
	    Session session = Factory.getCurrentSession();
	    Query<?> UQuery = session.createQuery(
	        "update Company set CName = :CName, CNumber = :CNumber, CEmail = :CEmail, " +
	        "CWebsite = :CWebsite, CAbout = :CAbout where CId = :CId"
	    );

	    UQuery.setParameter("CName", cy.getCName());
	    UQuery.setParameter("CNumber", cy.getCNumber());
	    UQuery.setParameter("CEmail", cy.getCEmail());
	    UQuery.setParameter("CWebsite", cy.getCWebsite());
	    UQuery.setParameter("CAbout", cy.getCAbout());
	    UQuery.setParameter("CId", cy.getCId());
	    UQuery.executeUpdate();
	}
	@Transactional
	public void UpdateData(Company cy) {
	    Session session = Factory.getCurrentSession();
	    Query<?> UQuery = session.createQuery(
	        "update Company set CName = :CName, CNumber = :CNumber, CEmail = :CEmail, " +
	        "CWebsite = :CWebsite, CAbout = :CAbout, CProfile = :CProfileFile where CId = :CId"
	    );

	    UQuery.setParameter("CName", cy.getCName());
	    UQuery.setParameter("CNumber", cy.getCNumber());
	    UQuery.setParameter("CEmail", cy.getCEmail());
	    UQuery.setParameter("CWebsite", cy.getCWebsite());
	    UQuery.setParameter("CAbout", cy.getCAbout());
	    UQuery.setParameter("CProfileFile", cy.getCProfileFile());
	    UQuery.setParameter("CId", cy.getCId());

	    UQuery.executeUpdate();
	}
	@Transactional
	public void InsertPostJob(CPostJob CPJ) {
		  hibernateTemplate.save(CPJ);
	}
	@Transactional
	public void InsertPProject(PProject pp) {
		hibernateTemplate.save(pp);
	}
	@Transactional
	public List<ApplyJob> getViewCandinateApplication(String CName) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM ApplyJob where AJCName = :AJCName And AJStatus =: AJStatus",ApplyJob.class);
		       Qy.setParameter("AJCName",CName);
		       Qy.setParameter("AJStatus","status");
		return Qy.getResultList();
	}
	@Transactional
	public void UpdateS(ApplyJob aj) {
		// TODO Auto-generated method stub
		Session session = Factory.getCurrentSession();
	    Query<ApplyJob> UQuery = session.createQuery(
	        "update ApplyJob set AJStatus = :AJStatus where AJId = :AJId");

	    UQuery.setParameter("AJStatus",aj.getAJStatus());
	    UQuery.setParameter("AJId",aj.getAJId());

	    UQuery.executeUpdate();

	}
	@Transactional
	public List<ApplyProject> getViewProjectCandinateApplication(String CName) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM ApplyProject where APName = :APName And APStatus =: APStatus",ApplyProject.class);
		       Qy.setParameter("APName",CName);
		       Qy.setParameter("APStatus","status");
		return Qy.getResultList();
	}
	@Transactional
	public void UpdateSProject(ApplyProject ap) {
		// TODO Auto-generated method stub
		Session session = Factory.getCurrentSession();
	    Query<ApplyProject> UQuery = session.createQuery(
	        "update ApplyProject set APStatus = :APStatus where APId = :APId");

	    UQuery.setParameter("APStatus",ap.getAPStatus());
	    UQuery.setParameter("APId",ap.getAPId());

	    UQuery.executeUpdate();

	}
	@Transactional
	public List<ApplyJob> getAcceptedData(String CName) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM ApplyJob where AJCName = :AJCName And AJStatus =: AJStatus",ApplyJob.class);
		       Qy.setParameter("AJCName",CName);
		       Qy.setParameter("AJStatus","Accepted");
		return Qy.getResultList();
	}
	@Transactional
	public List<ApplyProject> getRejectedData(String CName) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM ApplyProject where APName = :APName And APStatus =: APStatus",ApplyProject.class);
		       Qy.setParameter("APName",CName);
		       Qy.setParameter("APStatus","Rejected");
		return Qy.getResultList();
	}
	@Transactional
	public List<ApplyProject> getAcceptedProjectData(String CName) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM ApplyProject where APName = :APName And APStatus =: APStatus",ApplyProject.class);
		       Qy.setParameter("APName",CName);
		       Qy.setParameter("APStatus","Accepted");
		return Qy.getResultList();
	}
	@Transactional
	public List<ApplyProject> getRejectedProjectData(String CName) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM ApplyProject where APName = :APName And APStatus =: APStatus",ApplyProject.class);
		       Qy.setParameter("APName",CName);
		       Qy.setParameter("APStatus","Rejected");
		return Qy.getResultList();
	}
	@Transactional
	public List<CPostJob> getJobData(String CName) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM CPostJob where PJName = :PJName",CPostJob.class);
		       Qy.setParameter("PJName",CName);
		return Qy.getResultList();
	}
	@Transactional
	public List<PProject> getProjectProjectData(String CName) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM PProject where PName = :PName",PProject.class);
		       Qy.setParameter("PName",CName);
		return Qy.getResultList();
	}
	@Transactional
	public List<CPostJob> getEditData(int id) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM CPostJob where PJId = :PJId",CPostJob.class);
		       Qy.setParameter("PJId",id);
		return Qy.getResultList();
	}
	@Transactional
	public void getUpdateEditData(CPostJob cpj) {
		// TODO Auto-generated method stub
		Session session = Factory.getCurrentSession();
	    Query<CPostJob> UQuery = session.createQuery(
	        "update CPostJob set PJDescription = :PJDescription ,PJTitle = :PJTitle,PJSkills =:PJSkills,PJRole=:PJRole,PJSalary=:PJSalary,PJName=:PJName,PJEmail=:PJEmail where PJId = :PJId");

	    UQuery.setParameter("PJDescription",cpj.getPJDescription());
	    UQuery.setParameter("PJTitle",cpj.getPJTitle());
	    UQuery.setParameter("PJSkills",cpj.getPJSkills());
	    UQuery.setParameter("PJRole",cpj.getPJRole());
	    UQuery.setParameter("PJSalary",cpj.getPJSalary());
	    UQuery.setParameter("PJName",cpj.getPJName());
	    UQuery.setParameter("PJEmail",cpj.getPJEmail()); 
	    UQuery.setParameter("PJId",cpj.getPJId());
	    UQuery.executeUpdate();
	}
	@Transactional
	public void getDeleteJobData(int id) {
		// TODO Auto-generated method stub
		Session session = Factory.getCurrentSession();
	    Query<CPostJob> UQuery = session.createQuery(
	        "delete from CPostJob where PJId = :PJId");
	    UQuery.setParameter("PJId",id);
	    UQuery.executeUpdate(); 	
	}
	@Transactional
	public void getDeleteProjectData(int id) {
		// TODO Auto-generated method stub
		Session session = Factory.getCurrentSession();
	    Query<CPostJob> UQuery = session.createQuery(
	        "delete from PProject where PId = :PId");
	    UQuery.setParameter("PId",id);
	    UQuery.executeUpdate();
	}
	@Transactional
	public List<Freelancer> getViewAllFData(Freelancer fr) {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("FROM Freelancer",Freelancer.class);
		return Qy.getResultList();
	}
	@Transactional
	public Long getcountfreelancer() {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("select count(c) FROM Freelancer c",Long.class);
		return (Long) Qy.getSingleResult();
	}
	@Transactional
	public Long getcountjobs() {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("select count(c) FROM CPostJob c",Long.class);
		return (Long) Qy.getSingleResult();
	}
	@Transactional
	public Long getcountproject() {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("select count(c) FROM PProject c",Long.class);
		return (Long) Qy.getSingleResult();
	}
	@Transactional
	public Long getcountcompany() {
		// TODO Auto-generated method stub
		Session session=Factory.getCurrentSession();
		Query Qy=session.createQuery("select count(c) FROM Company c",Long.class);
		return (Long) Qy.getSingleResult();
	}
}
