package org.launchcode.hellospring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @RequestMapping(value="")
    @ResponseBody
    public String index(HttpServletRequest request){

        String name = request.getParameter("name");
        if (name == null){
            name = "World";
        }
        return ("Hello " + name + "!");
    }
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select id='language' name = 'language'>" +
                "<option value = 'English'> English</option>" +
                "<option value = 'French'> French</option>" +
                "<option value = 'Portuguese'> Portuguese</option>" +
                "<option value = 'Hawaiian'> Hawaiian</option>" +
                "<option value = 'Spanish'> Spanish</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        String greeting = "Hello";
        if (language.equals("English")){
            greeting = "Hello ";
        }
        else if (language.equals("Spanish")){
            greeting = "Hola ";
        }
        else if (language.equals("French")){
            greeting = "Bonjour ";
        }
        else if (language.equals("Portuguese")){
             greeting = "Ola ";
        }
        else if (language.equals("Hawaiian")){
             greeting = "Aloha ";
        }

        return (greeting + name);

    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloURLSegment(@PathVariable String name){
        return "Hello " + name;

    }
    @RequestMapping(value="goodbye")
    public String goodbye(){
        return "redirect:/";
    }
}
