package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import survey.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import java.util.Date;
import java.util.List;

import survey.entity.Reponse;

@Repository
public interface ReponseDao extends JpaRepository<Reponse, Integer> {
    @Query("Select count(e.response),e.response "
            + "from Reponse e group by  e.response having e.response is not null and e.response in ('1','2','3','4','5') ")
    public List<Object> get();
/*public static EntityManager em = null;
    @NamedNativeQuery("Select sum(  :num),e.responseId.msisdn "
            + "from Reponse e group by  e.responseId.msisdn  ")
    .setParameter("id", id)
    public List<Object> getScore()=this.;*/

    @Query("Select e.response     ,e.responseId.msisdn "
            + "from Reponse e group by  e.responseId  ")
    public List<Object> getScore();

    @Query("Select e.response     ,e.responseId.msisdn "
            + "from Reponse e group by  e.responseId Having e.responseId.enquete =:id ")
    public List<Object> getScoreByEnq(int id);

    @Query("Select e.response     ,t.param2 "
            + "from Reponse e , Targuet t  where e.responseId.enquete=t.targetId.enquete group by  e.responseId,t.param2  Having t.param2 like 'O%' ")
    public List<Object> getScoreByParam();


    @Query("Select count(e.response),e.response "
            + "from Reponse e group by  e.response,e.responseId.enquete having e.response is not null and e.response in ('1','2','3','4','5')  and e.responseId.enquete =:id")
    public List<Object> getByen(int id);




    @Query("Select count(e.response),e.response "
            + "from Reponse e  where e.responseId.enquete in (select r.id from Enquete r where r.startDate between :d1 and :d2 group by r.id) group by  e.response having e.response is not null and e.response in ('1','2','3','4','5')    ")
    public List<Object> getByDate(Date d1, Date d2);

  /*  @Query("Select e.response     ,e.responseId.msisdn "
            + "from Reponse e group by  e.responseId  ")
    public List<Object> getScore();*/

    @Query("Select e.response     ,e.responseId.msisdn "
            + "from Reponse e group by  e.responseId Having e.responseId.enquete in (select r.id from Enquete r where r.startDate between :d1 and :d2) ")
    public List<Object> getScoreByDate(Date d1, Date d2);



    @Query("Select count(e.response),e.response "
            + "from Reponse e where  e.responseId.enquete in (select r.id from Enquete r where r.channel ='Resurvey') group by  e.response having e.response is not null and e.response in ('1','2','3','4','5')    ")
    public List<Object> getResurvey1();


    @Query("Select e.response     ,e.responseId.msisdn "
            + "from Reponse e where  e.responseId.enquete in (select r.id from Enquete r where r.channel ='Resurvey') group by  e.responseId  ")
    public List<Object> getScoreResurvey();
}
