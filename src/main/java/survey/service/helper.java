package survey.service;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;



import java.io.IOException;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import survey.dao.DigitalTargetDao;
import survey.entity.DigitalTarget;


public class helper {
	
	@Autowired
	static
	DigitalTargetDao digitalTargetRepo;
	
	private static final Logger logger = LogManager.getLogger(helper.class);
	
	 public static String TYPE = "text/csv";
	
	  static String[] HEADERs = {"language","param1","param2","param3","msisdn_interaction","question_id","attempt","creation_date","original_enq_id","param4","param5","param6","param7","param8","param9","param10","motif_insatisfaction","etat","send_mail_resurvey","email","current_question"};
	  static String SHEET = "DigitalTargets";
	  
	  public static boolean hasCSVFormat(MultipartFile file) {
		  System.out.println("hascsvfile");
		     if (!file.getOriginalFilename().substring(file.getOriginalFilename().length()-3, file.getOriginalFilename().length()).equals("csv")) {
				  System.out.println("hasnocsvfile");

		            return false;
		        }
		        return true;
		  }
	  
	  
	  public static List<DigitalTarget> csvToTutorials(InputStream is)  {
	  
		  try {
logger.info("heyy");
			  BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			  fileReader.readLine();
			  SimpleDateFormat formateur=new SimpleDateFormat("yyyy-MM-dd"); 
              String line;
              List<DigitalTarget> digitalTargetList = new ArrayList<>();
              while ((line = fileReader.readLine()) != null) {
            	 
            	  logger.info("line : " + line);
            	  StringTokenizer st = new StringTokenizer(line, ",");
            	  
            	  while (st.countTokens() > 0  ) {
            		  DigitalTarget digitalTarget = new DigitalTarget();
            	
                    	digitalTarget.setLanguage(st.nextToken());
                    	digitalTarget.setParam1(st.nextToken());
                    	digitalTarget.setParam2(st.nextToken());
                    	digitalTarget.setParam3(st.nextToken());
                    	digitalTarget.setMsisdnInteraction(st.nextToken());
                    	digitalTarget.setQuestionId(Integer.parseInt(st.nextToken()));
                    	digitalTarget.setAttempt(Integer.parseInt(st.nextToken()));
                    	digitalTarget.setCreationDate(formateur.parse(st.nextToken()));
                    	digitalTarget.setOriginalEnqId(Integer.parseInt(st.nextToken()));
                    	digitalTarget.setParam4(st.nextToken());
                    	digitalTarget.setParam5(st.nextToken());
                    	digitalTarget.setParam6(st.nextToken());
                    	digitalTarget.setParam7(st.nextToken());
                    	digitalTarget.setParam8(st.nextToken());
                    	digitalTarget.setParam9(st.nextToken());
                    	digitalTarget.setParam10(st.nextToken());
                    	digitalTarget.setMotifInsatisfaction((st.nextToken()));
                    	digitalTarget.setEtat(st.nextToken());
                    	digitalTarget.setSendMailResurvey(Integer.parseInt(st.nextToken()));
                    	digitalTarget.setEmailCustomer(st.nextToken());
                    	digitalTarget.setCurrentQuestion(Integer.parseInt(st.nextToken()));
                    	digitalTargetList.add(digitalTarget);
                    	
            	  }
            	  
            	  
            	  
            	  
            	  
              }
              
              logger.info("liste : " + digitalTargetList.toString()); 
          	return digitalTargetList;
          	
          	
		  } 
		  catch (Exception  e) {
    		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
  		    }
		  
              
	
		  

	  }
	  
	  
	  
	  
	  
		  public static ByteArrayInputStream tutorialsToCSV(List<DigitalTarget> digitalTargetList) {
		    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

		    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
		        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
		      for (DigitalTarget digitalTarget : digitalTargetList) {
		    
		        List<String> data = Arrays.asList(
		             
		              String.valueOf(digitalTarget.getDigitalTargetID()),
		              String.valueOf(digitalTarget.getCurrentQuestion()),
		              digitalTarget.getLanguage(),
		              digitalTarget.getParam1(),
		              digitalTarget.getParam2(),
		              digitalTarget.getParam3(),
		              digitalTarget.getMsisdnInteraction(),
		              String.valueOf(digitalTarget.getQuestionId()),
		              String.valueOf(digitalTarget.getAttempt()),
		              String.valueOf(digitalTarget.getCreationDate()),
		              String.valueOf(digitalTarget.getOriginalEnqId()),
		              digitalTarget.getParam4(),
		              digitalTarget.getParam5(),
		              digitalTarget.getParam6(),
		              digitalTarget.getParam7(),
		              digitalTarget.getParam8(),
		              digitalTarget.getParam9(),
		              digitalTarget.getParam10(),
		              digitalTarget.getMotifInsatisfaction(),
		              digitalTarget.getEtat(),
		              String.valueOf(digitalTarget.getSendMailResurvey()),
		              digitalTarget.getEmailCustomer()
		            );

		        csvPrinter.printRecord(data);
		  
		      }

		      csvPrinter.flush();
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		    }
		  }
	 

}