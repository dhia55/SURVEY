package survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import survey.entity.CategorieDigital;
import survey.service.Impl.CategorieDigitalService;

@RestController
public class CategoryDigitalController {

  @Autowired
  CategorieDigitalService categorieDigitalService;

  @PostMapping("/addcategorieDigital")
  public CategorieDigital addrole(@RequestBody CategorieDigital c) {
    return categorieDigitalService.addCategorieDigitall(c);
  }

  @GetMapping("/getallcategorieDigitals")
  public List<CategorieDigital> getAll() {
    return categorieDigitalService.getAll();
  }

  @GetMapping("/getcategorieDigitalByid/{id}")
  public CategorieDigital getcategorieDigitalByid(@PathVariable("id") int id) {
    return categorieDigitalService.get(id);
  }


}
