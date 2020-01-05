package spring.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerTextArea {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-config.xml");
    private FactoryJDBC factoryJDBC = (FactoryJDBC) applicationContext.getBean("factory");

    @RequestMapping(value = "/bro", method = RequestMethod.GET)
    public String methodBro(ModelMap modelMap) {
        modelMap.addAttribute("mess", "bro");
        return "bro";
    }

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView xxxdPage() {
        FIleModel fIleModel = new FIleModel();
        ModelAndView modelAndView = new ModelAndView("fileUpload", "command", fIleModel);
        return modelAndView;
    }

    @RequestMapping(value = "/getxxx", method = RequestMethod.POST)
    public String xxxxx(@Validated FIleModel model, BindingResult bindingResult, ModelMap modelMap) throws Exception {
        if (bindingResult.hasErrors()) {
            return "fileUpload";
        } else {
            MultipartFile multipartFile = model.getFile();
            String originalFilename = multipartFile.getOriginalFilename();
            factoryJDBC.creat(originalFilename, 257);
            servletContext.getRealPath("");
            FileCopyUtils.copy(model.getFile().getBytes(), new File(model + model.getFile().getOriginalFilename()));
            modelMap.addAttribute("filename", originalFilename);
            return "success";
        }
    }
    /*

    @Autowired
    ServletContext context;

    */
    /*=====Fil  e Start==========*//*

    @RequestMapping(value = "/fileUploadPage", method = RequestMethod.GET)
    public ModelAndView fileUploadPage() {
        FIleModel file = new FIleModel();
        ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
        return modelAndView;
    }

    @RequestMapping(value = "/fileUploadPage", method = RequestMethod.POST)
    public String fileUpload(@Validated FIleModel file, BindingResult bindingResult, ModelMap modelMap) throws Exception {
        if (bindingResult.hasErrors()) {
            */
    /*error*//*

            return "fileUploadPage";
        } else {

            MultipartFile multipartFile = file.getFile();
            String bro = context.getRealPath("");

            String originalFilename = file.getFile().getOriginalFilename();
            factoryJDBC.creat(originalFilename, 1237);
            FileCopyUtils.copy(file.getFile().getBytes(), new File(bro + file.getFile().getOriginalFilename()));
                        String fileName = multipartFile.getOriginalFilename();
            modelMap.addAttribute("fileName", fileName);
            return "success";
        }
    }


*/

    /*============AND========*/


    @RequestMapping(value = "/")
    public ModelAndView methodGet() {
        Reg reg = new Reg();
        reg.setHobby(new String[]{"BodyBuilding", "Learn Java", "My family"});
        ModelAndView modelAndView = new ModelAndView("welcome", "command", reg);


        return modelAndView;
    }

    @RequestMapping(value = "/s")
    public ModelAndView methodGet2() {
        DataCafe dataCafe = new DataCafe();
        ModelAndView modelAndView2 = new ModelAndView("well", "command", dataCafe);

        return modelAndView2;
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String methodPost(@ModelAttribute Reg reg, @ModelAttribute DataCafe dataCafe, ModelMap map) {


        System.out.printf("===========BRO============");
        factoryJDBC.creat(dataCafe.getName(), dataCafe.getCode());


        List<DataCafe> listCafe = factoryJDBC.geListDataCafe();
        for (DataCafe dataCafe1 : listCafe) {
            System.out.println("ID _ " + dataCafe1.getId());
            System.out.println("Name _ " + dataCafe1.getName());
            System.out.println("Code_ " + dataCafe1.getCode());


            map.addAttribute("name", reg.getName());
            map.addAttribute("address", reg.getAddress());
            map.addAttribute("man", reg.isMan());
            map.addAttribute("have", reg.getHave());
            map.addAttribute("cafe", dataCafe1.getName());
            map.addAttribute("code", dataCafe1.getCode());
        }
        return "result";
    }

    @RequestMapping(value = "/xmlroot", method = RequestMethod.GET)
    public @ResponseBody
    DataCafe methodXML() {
        DataCafe dataCafe = new DataCafe();
        dataCafe.setCode(123);
        dataCafe.setId(789);
        dataCafe.setName("BRO");
        return dataCafe;
    }

    @ModelAttribute("hobbyList")
    public List<String> gethobbyList() {
        List<String> hobbyList = new ArrayList<String>();
        hobbyList.add("BodyBuilding");
        hobbyList.add("Learn Java");
        hobbyList.add("My family");
        hobbyList.add("BodyBuilding2");
        return hobbyList;
    }

    @ModelAttribute("have2")
    public String getHad() {
        String have = "Bro_Yes";
        return have;
    }

}



/*

    @RequestMapping(value = "/")
    public ModelAndView modelGet(){
        return new ModelAndView("welcome","command", new Reg());
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String methodPost(@ModelAttribute Reg reg , ModelMap map){
        map.addAttribute("name",reg.getName());
        return "result";
    }

*/
