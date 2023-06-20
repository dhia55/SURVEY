package survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import survey.entity.Echelle;
import survey.entity.*;
import survey.entity.Script;
import survey.service.EchelleService;
import survey.service.ReponseService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class ResponseController {
	
	@Autowired
    ReponseService rs;
    @GetMapping("/GetAllByid/{id}")
    public List<Object> getAll(@PathVariable("id") int id)
    {
        return rs.getById(id);
    }

    @GetMapping("/getScore")
    public List<ent> getAllScore()
    {


   //     System.out.println(rs.getScore().stream().mapToInt(e ->()).sum());
        return rs.getScore();
    }
    @GetMapping("/getScoreResurvey")
    public List<ent> getAllScoreR()
    {


        //     System.out.println(rs.getScore().stream().mapToInt(e ->()).sum());
        return rs.getSCResurvey();
    }

    @GetMapping("/getResurvey")
    public List<Object> getResurvey()
    {


        //     System.out.println(rs.getScore().stream().mapToInt(e ->()).sum());
        return rs.getResurvey();
    }
    @GetMapping("/getScoreByP")
    public List<Object> getscByp()
    {


        //     System.out.println(rs.getScore().stream().mapToInt(e ->()).sum());
        return rs.getScoreByparam();
    }


    @GetMapping("/getallreponseIn")
    public List<Object> getAllIn()
    {List<Object> obj=new ArrayList();
        for(int i=0;i< rs.get().size();i++)
        {
            System.out.println(rs.get().get(i));


        }



        return rs.get();
    }
    @GetMapping("/getallreponse")
    public List<Reponse> getAll()
    {
        return rs.getAll();
    }
    @DeleteMapping("/deletereponse/{id}")
    public boolean delete(@PathVariable("id") int id)
    {
        return rs.delete(id);
    }

    @PostMapping("/updaterep")
    public Reponse updatereponse(@RequestBody Reponse u)
    {
        return rs.update(u);

    }

    @GetMapping("/getreponsebyid/{id}")
    public Reponse getreponsebyid(@PathVariable("id") int id)
    {
        return rs.get(id);
    }

    @GetMapping("/getScoreById/{id}")
    public List<ent> getAllScorebYiD(@PathVariable("id") int id)
    {


        //     System.out.println(rs.getScore().stream().mapToInt(e ->()).sum());
        return rs.getScoreById(id);
    }


    @PostMapping("/addreponse")
    public Reponse addRep(@RequestBody Reponse e)
    {
        rs.addReponse(e);
        return e;

    }


    @GetMapping("/getScorebyDate/{d1}/{d2}")
    public List<Object> getScorebyDate(@PathVariable String d1,@PathVariable String d2) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);

        return rs.getScoreByDate(date,date1);
    }

    @GetMapping("/getScorebyDate1/{d1}/{d2}")
    public List<ent> getScorebyDateDate(@PathVariable String d1,@PathVariable String d2) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);

        return rs.getScoreByDATE(date,date1);
    }

}
