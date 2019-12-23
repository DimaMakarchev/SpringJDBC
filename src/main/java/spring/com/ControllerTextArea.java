package spring.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerTextArea {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-config.xml");
    private FactoryJDBC factoryJDBC = (FactoryJDBC) applicationContext.getBean("factory");


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
