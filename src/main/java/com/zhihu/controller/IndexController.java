package com.zhihu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping(path = {"/vm"}, method = {RequestMethod.GET})
    public String template(Model model) {
        model.addAttribute("value1", "vvvvv1");
        return "home";
    }

    @RequestMapping(path = {"/index"}, method = {RequestMethod.GET})
    @ResponseBody
    public String index() {
        return "Hello Zhihu";
    }


    @RequestMapping(path = {"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("userId") int userId,
                          @PathVariable("groupId") int groupId,
                          @RequestParam(value = "type", defaultValue = "1") int type,
                          @RequestParam(value = "page", required = false) String key) {
        return String.format("Profile Page of %s / %d, t:%d k: %s", groupId, userId, type, key);
    }



}
