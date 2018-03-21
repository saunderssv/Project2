package p2.backend.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import p2.backend.BackendApplication;
import p2.backend.Beans.Animal;
import p2.backend.Service.AnimalService;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
//@WebMvcTest(value=AnimalController.class)
@SpringBootTest(classes = BackendApplication.class)
public class AnimalControllerTest {

    //@Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private AnimalService animalService;

    Animal mockAnimal = new Animal("Spencer", "Mathematician turnedprogrammer","likes math", "loves math", 1, 1, "notes");
    String exampleAnimalJson = "{\"animalId\":1,\"animalName\":\"Spencer\",\"scientificName\":\"Mathematician turnedprogrammer\",\"funFact\":\"likes math\",\"summary\":\"loves math\",\"numOfAnimal\":1,\"tracking\":1, \"notes\":\"notes\"}";

    @Before
    public void setup() throws Exception{
        Mockito.when(animalService.byAnimal(Mockito.anyString())).thenReturn(mockAnimal);
    }

    @Test
    public void testByAnimal() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/Animal/?name=someanimal").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "{animalId : 1, animalName : Spencer, scientificName : Mathematician turnedprogrammer, funFact : likes math, summary : loves math, numOfAnimal:1, tracking : 1, notes : notes}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }



}