package ProjectPulse.Doa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ProjectPulse.Model.ApplyJob;
import ProjectPulse.Model.ApplyProject;
import ProjectPulse.Model.CPostJob;
import ProjectPulse.Model.Company;
import ProjectPulse.Model.Freelancer;
import ProjectPulse.Model.PProject;

@Component
public class FreeDoa {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private SessionFactory Factory;
	
	@Transactional
	public void RegisterFreelancer(Freelancer Fr) {
		 hibernateTemplate.save(Fr);
	}
	
	@Transactional
	public  List<Freelancer> ReLoginData(String Email,String Pass) {
		Session session=Factory.getCurrentSession();
		Query<Freelancer> Qy=session.createQuery("FROM Freelancer where FEmail = :FEmail AND FPassword = :FPassword",Freelancer.class);
		       Qy.setParameter("FEmail",Email);
		       Qy.setParameter("FPassword",Pass);
		return Qy.getResultList();
	}
	@Transactional
	public List<Freelancer> CheckEmail(String Email){
		Session session=Factory.getCurrentSession();
		Query<Freelancer> Qy=session.createQuery("FROM Freelancer where FEmail = :FEmail",Freelancer.class);
		       Qy.setParameter("FEmail",Email);
		return Qy.getResultList();
	}
	@Transactional
	public void UpdateProFreelancer(Freelancer Fr) {
	    Session session = Factory.getCurrentSession();
	    Query<Freelancer> UQuery = session.createQuery(
	        "update Freelancer set FPProfile = :FProfileFile,FName = :FName, FNumber = :FNumber, FEmail = :FEmail, " +
	        "FLinkdin = :FLinkdin, FEducation = :FEducation, FCharge = :FCharge,FSkills = :FSkills where FId = :FId"
	    );
        UQuery.setParameter("FProfileFile",Fr.getFPProfile());
	    UQuery.setParameter("FName", Fr.getFName());
	    UQuery.setParameter("FNumber",Fr.getFNumber());
	    UQuery.setParameter("FEmail",Fr.getFEmail());
	    UQuery.setParameter("FLinkdin",Fr.getFLinkdin());
	    UQuery.setParameter("FEducation",Fr.getFEducation());
	    UQuery.setParameter("FCharge",Fr.getFCharge());
	    UQuery.setParameter("FSkills",Fr.getFSkills());
	    UQuery.setParameter("FId",Fr.getFId());

	    UQuery.executeUpdate();
	}	
	@Transactional
	public void UpdateWithOutProFreelancer(Freelancer Fr) {
	    Session session = Factory.getCurrentSession();
	    Query<Freelancer> UQuery = session.createQuery(
	        "update Freelancer set FName = :FName, FNumber = :FNumber, FEmail = :FEmail, " +
	        "FLinkdin = :FLinkdin, FEducation = :FEducation, FCharge = :FCharge,FSkills = :FSkills where FId = :FId"
	    );
	    UQuery.setParameter("FName", Fr.getFName());
	    UQuery.setParameter("FNumber",Fr.getFNumber());
	    UQuery.setParameter("FEmail",Fr.getFEmail());
	    UQuery.setParameter("FLinkdin",Fr.getFLinkdin());
	    UQuery.setParameter("FEducation",Fr.getFEducation());
	    UQuery.setParameter("FCharge",Fr.getFCharge());
	    UQuery.setParameter("FSkills",Fr.getFSkills());
	    UQuery.setParameter("FId",Fr.getFId());

	    UQuery.executeUpdate();
	}
	@Transactional
	public List<CPostJob> ShowAllData() {
		String hql = "FROM CPostJob j WHERE j.PJName IS NOT NULL ORDER BY rand()";
	    return (List<CPostJob>) hibernateTemplate.find(hql);
	}

	public List<PProject> GetEProject() {
		return hibernateTemplate.loadAll(PProject.class);
	}

    @Transactional
    public List<CPostJob> getCPostJob(int id) {
        Session session = Factory.getCurrentSession();
        Query<CPostJob> Qy = session.createQuery(
            "FROM CPostJob where PJId = :PJId", CPostJob.class
        );
        Qy.setParameter("PJId", id);
        return Qy.getResultList();
    }
    @Transactional
    public List<PProject> getPProject(int id) {
        Session session = Factory.getCurrentSession();
        Query<PProject> Qy = session.createQuery(
            "FROM PProject where PId = :PId", PProject.class
        );
        Qy.setParameter("PId", id);
        return Qy.getResultList();
    }
    @Transactional
	public void SaveApplyJob(ApplyJob aj) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(aj);
	}
    
    @Transactional
	public void SaveApplyProject(ApplyProject ap) {
		// TODO Auto-generated method stub
		 hibernateTemplate.save(ap);
	}
    @Transactional
	public List<ApplyJob> getApplyJobData(String fEmail) {
		// TODO Auto-generated method stub
		Session session = Factory.getCurrentSession();
        Query<ApplyJob> Qy = session.createQuery(
            "FROM ApplyJob where AJFEmail = :AJFEmail", ApplyJob.class
        );
        Qy.setParameter("AJFEmail",fEmail);
        return Qy.getResultList();
	}
    @Transactional
	public List<ApplyProject> getApplyProjectData(String fEmail) {
		// TODO Auto-generated method stub
		Session session = Factory.getCurrentSession();
        Query<ApplyProject> Qy = session.createQuery(
            "FROM ApplyProject where APCEmail = :APCEmail",ApplyProject.class
        );
        Qy.setParameter("APCEmail",fEmail);
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
	@Transactional
	public List<CPostJob> getjobdata() {
		String hql = "FROM CPostJob j WHERE j.PJName IS NOT NULL ORDER BY rand()";
	    return (List<CPostJob>) hibernateTemplate.find(hql);
	}
    @Transactional
	public List<PProject> getApplyProjectData() {
		// TODO Auto-generated method stub
		Session session = Factory.getCurrentSession();
        Query<PProject> Qy = session.createQuery(
            "FROM PProject",PProject.class
        );
        return Qy.getResultList();
	}

}
