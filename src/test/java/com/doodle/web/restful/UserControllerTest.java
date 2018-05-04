package com.doodle.web.restful;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author 周云龙
 * @date 2018/5/3 9:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class UserControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null;

        //遍历
        request = get("/users/");
        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        //添加
        request = MockMvcRequestBuilders.post("/users/")
                .param("id", "1")
                .param("name", "peter")
                .param("age", "19");
        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")))
                .andDo(print());

        //遍历
        request = get("/users/");
        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"peter\",\"age\":19}]")));

        //修改
        request = put("/users/1")
                .param("name", "lulu")
                .param("age", "18");
        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));
        //遍历
        request = get("/users/");
        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"lulu\",\"age\":18}]")))
                .andDo(print());

        //get一个id为1的user
        request = get("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"lulu\",\"age\":18}")));
        //删除
        request = delete("/users/1");
        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));
        //遍历
        request = get("/users/");
        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

}
