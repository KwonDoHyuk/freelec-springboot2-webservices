package com.jojoldu.book.springboot;




import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        })
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;  //mvc를 기능을 사용하게 함.

    @Test
    @WithMockUser(roles="USER")
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) //get매핑 /hello
                .andExpect(status().isOk())  //http.status 200일때
                .andExpect(content().string(hello)); //hello가 기대될때
    }

    @Test
    @WithMockUser(roles="USER")
    public void helloDto() throws Exception{
            String name ="hello";
            int amount = 1000;

            mvc.perform(get("/hello/dto")
                    .param("name",name)
                    .param("amount",String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name2",is(name)))
                    .andExpect(jsonPath("$.amount",is(amount)));
    }
}
