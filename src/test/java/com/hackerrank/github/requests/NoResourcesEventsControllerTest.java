package com.hackerrank.github.requests;

import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;
import com.hackerrank.test.utility.ResultMatcher;
import com.hackerrank.test.utility.TestWatchman;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoResourcesEventsControllerTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
    
    @Rule
    public TestWatcher watchman = TestWatchman.watchman;
    
    @Autowired
    private MockMvc mockMvc;

    @BeforeClass
    public static void setUpClass() {
        TestWatchman.watchman.registerClass(NoResourcesEventsControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(NoResourcesEventsControllerTest.class);
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding all the events
     */
    @Test
    @Order(1)
    public void findAllEvents() throws Exception {
        /**
         *
         * Find all the events
         *
         * The request response is:
         * []
         */
        String res = "[]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/events"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding all the events by repository id and actor id
     */
    @Test
    @Order(2)
    public void findAllEventsByNonExistingRepoIdAndNonExistingActorId() throws Exception {
        /**
         *
         * Find all the events by non-existing repository id 1 and non-existing actor id 1
         */
        mockMvc.perform(get("/events/repos/1/actors/1"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding all the events by actor id
     */
    @Test
    @Order(3)
    public void findAllEventsByNonExistingActorId() throws Exception {
        /**
         *
         * Find all the events by non-existing actor id 1
         */
        mockMvc.perform(get("/events/actors/1"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding all the events by actor id
     */
    @Test
    @Order(4)
    public void findAllEventsByNonExistingRepoId() throws Exception {
        /**
         *
         * Find all the events by non-existing repository id 1
         */
        mockMvc.perform(get("/events/repos/1"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding an event
     */
    @Test
    @Order(5)
    public void findEventByNonExistingId() throws Exception {
        /**
         *
         * Find event by non-existing id 1
         */
        mockMvc.perform(get("/events/1"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests creating an event
     */
    @Test
    @Order(6)
    public void createEvent() throws Exception {
        /**
         *
         * Create event with id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 3,
         *         "login": "christinelewis",
         *         "avatar_url": "https://avatars.com/christinelewis"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "kelly/esse",
         *         "url": "https://github.com/kelly/esse"
         *     },
         *     "created_at": "2018-12-28 01:29:02"
         * }
         */
        String json = "{\"id\": 1, \"type\": \"PushEvent\", \"actor\": {\"id\": 3, \"login\": \"christinelewis\", \"avatar_url\": \"https://avatars.com/christinelewis\"}, \"repo\": {\"id\": 1, \"name\": \"kelly/esse\", \"url\": \"https://github.com/kelly/esse\"}, \"created_at\": \"2018-12-28 01:29:02\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());
    }

    /**
     *
     * @throws Exception
     *
     * It tests creating an event
     */
    @Test
    @Order(7)
    public void createEventWithExistingId() throws Exception {
        /**
         *
         * Create event with existing id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 3,
         *         "login": "christinelewis",
         *         "avatar_url": "https://avatars.com/christinelewis"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "kelly/esse",
         *         "url": "https://github.com/kelly/esse"
         *     },
         *     "created_at": "2018-12-28 01:29:02"
         * }
         */
        String json = "{\"id\": 1, \"type\": \"PushEvent\", \"actor\": {\"id\": 3, \"login\": \"christinelewis\", \"avatar_url\": \"https://avatars.com/christinelewis\"}, \"repo\": {\"id\": 1, \"name\": \"kelly/esse\", \"url\": \"https://github.com/kelly/esse\"}, \"created_at\": \"2018-12-28 01:29:02\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isBadRequest());
    }
}
