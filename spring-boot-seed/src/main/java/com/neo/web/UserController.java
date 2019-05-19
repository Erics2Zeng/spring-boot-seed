package com.neo.web;
import com.neo.core.BaseController;
import com.neo.core.ResponseBo;
import com.neo.model.User;
import com.neo.service.UserService;
import com.neo.param.QueryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2019/05/19.
*/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public ResponseBo add(User user) {
        try{
            userService.save(user);
            return ResponseBo.ok("");
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }

    }

    @GetMapping("/delete")
    public ResponseBo delete(@RequestParam Integer id) {
         try{
             userService.delete(id);
             return ResponseBo.ok("");
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }
    }

    @PostMapping("/update")
    public ResponseBo update(User user) {
         try{
             userService.updateAll(user);
             return ResponseBo.ok("");
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }
    }

    @GetMapping("/detail")
    public ResponseBo detail(@RequestParam Integer id) {
        try{
            User user = userService.selectByKey(id);
            return ResponseBo.ok(user);
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }
    }

    @GetMapping("/list")
    public Map<String, Object>  list(QueryRequest request) {
       try{
            return this.selectByPageNumSize(request,()->userService.selectAll());
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }
    }

    @GetMapping("/all")
    public ResponseBo getAll() {
        try{
            List<User> list = userService.selectAll();
            return ResponseBo.ok(list);
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }
    }
}
