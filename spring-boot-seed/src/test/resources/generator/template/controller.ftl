package ${basePackage}.web;
import ${basePackage}.core.BaseController;
import ${basePackage}.core.ResponseBo;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.params.QueryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller extends BaseController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public ResponseBo add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        try{
            ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
            return ResponseBo.ok("");
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }

    }

    @GetMapping("/delete")
    public ResponseBo delete(@RequestParam Integer id) {
         try{
             ${modelNameLowerCamel}Service.delete(id);
             return ResponseBo.ok("");
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }
    }

    @PostMapping("/update")
    public ResponseBo update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
         try{
             ${modelNameLowerCamel}Service.updateAll(${modelNameLowerCamel});
             return ResponseBo.ok("");
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }
    }

    @GetMapping("/detail")
    public ResponseBo detail(@RequestParam Integer id) {
        try{
            ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectByKey(id);
            return ResponseBo.ok(${modelNameLowerCamel});
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
            List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.selectAll();
            return ResponseBo.ok(list);
        }catch(Exception e){
            logger.error("xxxx", e);
            return ResponseBo.error("xxxx");
        }
    }
}
