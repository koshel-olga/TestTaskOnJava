package ru.testtaskolga.testtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestTaskRestController {

    @Autowired
    TestTaskService serviceRegion;

    @RequestMapping("/search")
    public Region search(@RequestParam(value="name", required=false, defaultValue="Приволжский федеральный округ") String name,
                         @RequestParam(value="type", required=false, defaultValue="ФО") String type) {
        return serviceRegion.getRegionInfo(name,type);
    }


}
