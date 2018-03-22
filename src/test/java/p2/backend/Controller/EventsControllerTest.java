package p2.backend.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import p2.backend.BackendApplication;
import p2.backend.Beans.Events;
import p2.backend.Service.EventsService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BackendApplication.class)
@SpringBootTest
public class EventsControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private EventsService eventsService;
    Events evt1 = new Events("Event1", "location", "time");
    Events evt2 = new Events("Event2", "location", "time");



    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }
    @Test
    public void eventList() throws Exception {

        List<Events> result = new ArrayList<>();
        result.add(evt1);
        result.add(evt2);
        Mockito.when(eventsService.listOfEvents()).thenReturn(result);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/Events/").accept(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(response.getResponse());
        String expected = "[{\"what\": \"Event1\",\"where\": \"location\",\"when\": \"time\" }, {\"what\": \"Event2\",\"where\": \"location\",\"when\": \"time\"}]";
        JSONAssert.assertEquals(expected, response.getResponse().getContentAsString(), false);

    }

    @Test
    public void saveEvent() throws Exception   {
//        Events mockEvent = evt1;
//
//        Mockito.when(
//                eventsService.saveEvent(Mockito.any(Events.class))).thenReturn("tested");
//                String exampleEventJson = "{\"what\": \"Event1\",\"where\": \"location\",\"when\": \"time\" }";
//
//        // Send course as body to /students/Student1/courses
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/Events/save")
//                .accept(MediaType.APPLICATION_JSON).content(exampleEventJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

//        assertEquals("http://localhost/students/Student1/courses/1",
//                response.getHeader(HttpHeaders.LOCATION));

    }

    @Test
    public void deleteEvent() {
    }
}