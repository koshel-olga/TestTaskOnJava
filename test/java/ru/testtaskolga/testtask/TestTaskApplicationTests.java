package ru.testtaskolga.testtask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public  class TestTaskApplicationTests {
    @Autowired
    private TestTaskService service;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        mockMvc.perform(get("/search?name=Смоленская область&type=область")
                            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void emptyContextLoads() throws Exception {
        mockMvc.perform(get("/search?name=bjhbjbjbj")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void cacheCheck() throws Exception {
        System.out.println("region found: "+ service.getRegionInfo("Нижегородская область", "область"));
        System.out.println("region found: "+ service.getRegionInfo("Нижегородская область", "область"));
        TimeUnit.SECONDS.sleep(16);
        System.out.println("region found: "+ service.getRegionInfo("Нижегородская область", "область"));
    }

}
