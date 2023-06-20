package survey.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import survey.dao.DigitalTargetDao;
import survey.entity.DigitalTarget;
import survey.entity.ResponseMessage;
import survey.service.Impl.DigitalTargetService;
import survey.service.Impl.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class DigitalTargetController {

  private static final Logger logger = LogManager.getLogger(DigitalTargetController.class);

  @Autowired
  DigitalTargetService digitalTargetService;

  @Autowired
  DigitalTargetDao DigitalTargetDao;

  @GetMapping("/getAlldigitalTargets")
  public List<DigitalTarget> getAll() {
    return digitalTargetService.getAll();
  }


  @GetMapping("/gettargetByenqId/{id}")
  public DigitalTarget gettargetByenqId(@PathVariable("id") int id) {
    return digitalTargetService.gettargetByenqId(id);
  }


  @PostMapping("/updatedigitalTarget")
  public DigitalTarget updatedigitalTarget(@RequestBody DigitalTarget t) {
    return digitalTargetService.update(t);

  }


  @GetMapping("/getAlldigitalTargetsByUser")
  public List<DigitalTarget> getAllByUser() {
    return digitalTargetService.getAllByUser();
  }

  @GetMapping("/getAlldigitalTargetsbyenqid/{id}/{lang}/{email}")
  public DigitalTarget getAllbyenqid(@PathVariable("id") int id, @PathVariable("lang") String lang, @PathVariable("email") String email) {
    return DigitalTargetDao.gettargetsbyenq(id, lang, email);
  }

  @PostMapping("/adddigitaltarget/{id}")
  public DigitalTarget adddigitaltarget(@RequestBody DigitalTarget t, @PathVariable("id") int id) {
    digitalTargetService.adddigitalTarget(t, id);
    return t;
  }


  @PostMapping("/deletedigitalTarget")
  public boolean delete(@RequestBody DigitalTarget t) {
    return digitalTargetService.deleteDigital(t);
  }

  @PostMapping("/uploaddigitaltarget/{id}")
  public ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file, @PathVariable("id") int id) {
    String message = "";

    if (helper.hasCSVFormat(file)) {
      try {
        logger.info("heyy");
        digitalTargetService.save(file, id);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
          .path("/downloaddigitaltargets/")
          .path(file.getOriginalFilename())
          .toUriString();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, fileDownloadUri));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, ""));
      }
    }

    message = "Please upload a csv file  " + file.getOriginalFilename() + "!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message, ""));
  }

  @PostMapping("/getbefore")
  public List<DigitalTarget> get(@RequestParam("file") MultipartFile file) {
    List<DigitalTarget> list = new ArrayList<DigitalTarget>();
    //	System.out.println("getBefore "+file.getName());

    if (helper.hasCSVFormat(file)) {
      try {
        //	System.out.println("tryy");
        list = digitalTargetService.getAllbefore(file);
        //	 System.out.println("list : "+list.get(0).getParam1());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return list;

  }


  @GetMapping("/getalldigitaltargets")
  public ResponseEntity<List<DigitalTarget>> getAllTutorials() {
    try {
      List<DigitalTarget> tutorials = digitalTargetService.getAll();

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/downloaddigitaltargets/{fileName:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
    InputStreamResource file = new InputStreamResource(digitalTargetService.load());

    return ResponseEntity.ok()
      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
      .contentType(MediaType.parseMediaType("application/csv"))
      .body(file);
  }

  @PostMapping("/sendtargets/{id}/{language}")
  // @ResponseBody
  public String sendtargets(@PathVariable("id") int id, @PathVariable("language") String language) throws MessagingException {
    digitalTargetService.sendtargets(id, language);


    return "done";
  }

  @GetMapping("/decodedUrl/{decodedUrl}")
  public String decodedUrl(@PathVariable("decodedUrl") String decodedUrl) {

    return digitalTargetService.decodedUrl(decodedUrl);
  }


  @GetMapping("/encodedUrl/{id}/{lang}")
  public String encodedUrl(@PathVariable("id") int id, @PathVariable("lang") String lang) {

    return digitalTargetService.encodedUrl(id, lang);
  }


  @GetMapping("/targetNumber/{id}")
  public int targetNumber(@PathVariable("id") int id) {
    return digitalTargetService.targetNumber(id);
  }

  @PostMapping("/sendbyemail/{id}")
  // @ResponseBody
  public String sendbyemail(@PathVariable("id") int id) throws MessagingException {
    digitalTargetService.sendbyemail(id);


    return "done";
  }


  @GetMapping("/generateLink/{id}")
  public String generateLink(@PathVariable("id") int id) {

    return digitalTargetService.generateLink(id);
  }

  @GetMapping("/generateLinkLang/{id}/{lang}")
  public String generateLinkLang(@PathVariable("id") int id, @PathVariable("lang") String language) {

    return digitalTargetService.generateLinkLang(id, language);
  }


}
