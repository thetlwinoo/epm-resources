package com.epmresources.server.web.rest;

import com.epmresources.server.EpmresourcesApp;
import com.epmresources.server.service.PaypalClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the PaypalClientResource REST controller.
 *
 * @see PaypalClientResource
 */
@SpringBootTest(classes = EpmresourcesApp.class)
public class PaypalClientResourceIT {

    private MockMvc restMockMvc;
    private final PaypalClientService paypalClientService;

    public PaypalClientResourceIT(PaypalClientService paypalClientService) {
        this.paypalClientService = paypalClientService;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        PaypalClientResource paypalClientResource = new PaypalClientResource(paypalClientService);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(paypalClientResource)
            .build();
    }

    /**
     * Test defaultAction
     */
    @Test
    public void testDefaultAction() throws Exception {
        restMockMvc.perform(get("/api/paypal-client/default-action"))
            .andExpect(status().isOk());
    }
}
