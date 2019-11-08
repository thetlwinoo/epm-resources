package com.epmresources.server.web.rest;

import com.epmresources.server.EpmresourcesApp;
import com.epmresources.server.domain.DangerousGoods;
import com.epmresources.server.domain.StockItems;
import com.epmresources.server.repository.DangerousGoodsRepository;
import com.epmresources.server.service.DangerousGoodsService;
import com.epmresources.server.service.dto.DangerousGoodsDTO;
import com.epmresources.server.service.mapper.DangerousGoodsMapper;
import com.epmresources.server.web.rest.errors.ExceptionTranslator;
import com.epmresources.server.service.dto.DangerousGoodsCriteria;
import com.epmresources.server.service.DangerousGoodsQueryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static com.epmresources.server.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link DangerousGoodsResource} REST controller.
 */
@SpringBootTest(classes = EpmresourcesApp.class)
public class DangerousGoodsResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    @Autowired
    private DangerousGoodsRepository dangerousGoodsRepository;

    @Autowired
    private DangerousGoodsMapper dangerousGoodsMapper;

    @Autowired
    private DangerousGoodsService dangerousGoodsService;

    @Autowired
    private DangerousGoodsQueryService dangerousGoodsQueryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restDangerousGoodsMockMvc;

    private DangerousGoods dangerousGoods;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DangerousGoodsResource dangerousGoodsResource = new DangerousGoodsResource(dangerousGoodsService, dangerousGoodsQueryService);
        this.restDangerousGoodsMockMvc = MockMvcBuilders.standaloneSetup(dangerousGoodsResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DangerousGoods createEntity(EntityManager em) {
        DangerousGoods dangerousGoods = new DangerousGoods()
            .name(DEFAULT_NAME);
        return dangerousGoods;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DangerousGoods createUpdatedEntity(EntityManager em) {
        DangerousGoods dangerousGoods = new DangerousGoods()
            .name(UPDATED_NAME);
        return dangerousGoods;
    }

    @BeforeEach
    public void initTest() {
        dangerousGoods = createEntity(em);
    }

    @Test
    @Transactional
    public void createDangerousGoods() throws Exception {
        int databaseSizeBeforeCreate = dangerousGoodsRepository.findAll().size();

        // Create the DangerousGoods
        DangerousGoodsDTO dangerousGoodsDTO = dangerousGoodsMapper.toDto(dangerousGoods);
        restDangerousGoodsMockMvc.perform(post("/api/dangerous-goods")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dangerousGoodsDTO)))
            .andExpect(status().isCreated());

        // Validate the DangerousGoods in the database
        List<DangerousGoods> dangerousGoodsList = dangerousGoodsRepository.findAll();
        assertThat(dangerousGoodsList).hasSize(databaseSizeBeforeCreate + 1);
        DangerousGoods testDangerousGoods = dangerousGoodsList.get(dangerousGoodsList.size() - 1);
        assertThat(testDangerousGoods.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void createDangerousGoodsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dangerousGoodsRepository.findAll().size();

        // Create the DangerousGoods with an existing ID
        dangerousGoods.setId(1L);
        DangerousGoodsDTO dangerousGoodsDTO = dangerousGoodsMapper.toDto(dangerousGoods);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDangerousGoodsMockMvc.perform(post("/api/dangerous-goods")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dangerousGoodsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DangerousGoods in the database
        List<DangerousGoods> dangerousGoodsList = dangerousGoodsRepository.findAll();
        assertThat(dangerousGoodsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = dangerousGoodsRepository.findAll().size();
        // set the field null
        dangerousGoods.setName(null);

        // Create the DangerousGoods, which fails.
        DangerousGoodsDTO dangerousGoodsDTO = dangerousGoodsMapper.toDto(dangerousGoods);

        restDangerousGoodsMockMvc.perform(post("/api/dangerous-goods")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dangerousGoodsDTO)))
            .andExpect(status().isBadRequest());

        List<DangerousGoods> dangerousGoodsList = dangerousGoodsRepository.findAll();
        assertThat(dangerousGoodsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllDangerousGoods() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        // Get all the dangerousGoodsList
        restDangerousGoodsMockMvc.perform(get("/api/dangerous-goods?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dangerousGoods.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)));
    }
    
    @Test
    @Transactional
    public void getDangerousGoods() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        // Get the dangerousGoods
        restDangerousGoodsMockMvc.perform(get("/api/dangerous-goods/{id}", dangerousGoods.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(dangerousGoods.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME));
    }

    @Test
    @Transactional
    public void getAllDangerousGoodsByNameIsEqualToSomething() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        // Get all the dangerousGoodsList where name equals to DEFAULT_NAME
        defaultDangerousGoodsShouldBeFound("name.equals=" + DEFAULT_NAME);

        // Get all the dangerousGoodsList where name equals to UPDATED_NAME
        defaultDangerousGoodsShouldNotBeFound("name.equals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllDangerousGoodsByNameIsNotEqualToSomething() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        // Get all the dangerousGoodsList where name not equals to DEFAULT_NAME
        defaultDangerousGoodsShouldNotBeFound("name.notEquals=" + DEFAULT_NAME);

        // Get all the dangerousGoodsList where name not equals to UPDATED_NAME
        defaultDangerousGoodsShouldBeFound("name.notEquals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllDangerousGoodsByNameIsInShouldWork() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        // Get all the dangerousGoodsList where name in DEFAULT_NAME or UPDATED_NAME
        defaultDangerousGoodsShouldBeFound("name.in=" + DEFAULT_NAME + "," + UPDATED_NAME);

        // Get all the dangerousGoodsList where name equals to UPDATED_NAME
        defaultDangerousGoodsShouldNotBeFound("name.in=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllDangerousGoodsByNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        // Get all the dangerousGoodsList where name is not null
        defaultDangerousGoodsShouldBeFound("name.specified=true");

        // Get all the dangerousGoodsList where name is null
        defaultDangerousGoodsShouldNotBeFound("name.specified=false");
    }
                @Test
    @Transactional
    public void getAllDangerousGoodsByNameContainsSomething() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        // Get all the dangerousGoodsList where name contains DEFAULT_NAME
        defaultDangerousGoodsShouldBeFound("name.contains=" + DEFAULT_NAME);

        // Get all the dangerousGoodsList where name contains UPDATED_NAME
        defaultDangerousGoodsShouldNotBeFound("name.contains=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllDangerousGoodsByNameNotContainsSomething() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        // Get all the dangerousGoodsList where name does not contain DEFAULT_NAME
        defaultDangerousGoodsShouldNotBeFound("name.doesNotContain=" + DEFAULT_NAME);

        // Get all the dangerousGoodsList where name does not contain UPDATED_NAME
        defaultDangerousGoodsShouldBeFound("name.doesNotContain=" + UPDATED_NAME);
    }


    @Test
    @Transactional
    public void getAllDangerousGoodsByStockItemIsEqualToSomething() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);
        StockItems stockItem = StockItemsResourceIT.createEntity(em);
        em.persist(stockItem);
        em.flush();
        dangerousGoods.setStockItem(stockItem);
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);
        Long stockItemId = stockItem.getId();

        // Get all the dangerousGoodsList where stockItem equals to stockItemId
        defaultDangerousGoodsShouldBeFound("stockItemId.equals=" + stockItemId);

        // Get all the dangerousGoodsList where stockItem equals to stockItemId + 1
        defaultDangerousGoodsShouldNotBeFound("stockItemId.equals=" + (stockItemId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultDangerousGoodsShouldBeFound(String filter) throws Exception {
        restDangerousGoodsMockMvc.perform(get("/api/dangerous-goods?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dangerousGoods.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)));

        // Check, that the count call also returns 1
        restDangerousGoodsMockMvc.perform(get("/api/dangerous-goods/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultDangerousGoodsShouldNotBeFound(String filter) throws Exception {
        restDangerousGoodsMockMvc.perform(get("/api/dangerous-goods?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restDangerousGoodsMockMvc.perform(get("/api/dangerous-goods/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("0"));
    }


    @Test
    @Transactional
    public void getNonExistingDangerousGoods() throws Exception {
        // Get the dangerousGoods
        restDangerousGoodsMockMvc.perform(get("/api/dangerous-goods/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDangerousGoods() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        int databaseSizeBeforeUpdate = dangerousGoodsRepository.findAll().size();

        // Update the dangerousGoods
        DangerousGoods updatedDangerousGoods = dangerousGoodsRepository.findById(dangerousGoods.getId()).get();
        // Disconnect from session so that the updates on updatedDangerousGoods are not directly saved in db
        em.detach(updatedDangerousGoods);
        updatedDangerousGoods
            .name(UPDATED_NAME);
        DangerousGoodsDTO dangerousGoodsDTO = dangerousGoodsMapper.toDto(updatedDangerousGoods);

        restDangerousGoodsMockMvc.perform(put("/api/dangerous-goods")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dangerousGoodsDTO)))
            .andExpect(status().isOk());

        // Validate the DangerousGoods in the database
        List<DangerousGoods> dangerousGoodsList = dangerousGoodsRepository.findAll();
        assertThat(dangerousGoodsList).hasSize(databaseSizeBeforeUpdate);
        DangerousGoods testDangerousGoods = dangerousGoodsList.get(dangerousGoodsList.size() - 1);
        assertThat(testDangerousGoods.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingDangerousGoods() throws Exception {
        int databaseSizeBeforeUpdate = dangerousGoodsRepository.findAll().size();

        // Create the DangerousGoods
        DangerousGoodsDTO dangerousGoodsDTO = dangerousGoodsMapper.toDto(dangerousGoods);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDangerousGoodsMockMvc.perform(put("/api/dangerous-goods")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dangerousGoodsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DangerousGoods in the database
        List<DangerousGoods> dangerousGoodsList = dangerousGoodsRepository.findAll();
        assertThat(dangerousGoodsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDangerousGoods() throws Exception {
        // Initialize the database
        dangerousGoodsRepository.saveAndFlush(dangerousGoods);

        int databaseSizeBeforeDelete = dangerousGoodsRepository.findAll().size();

        // Delete the dangerousGoods
        restDangerousGoodsMockMvc.perform(delete("/api/dangerous-goods/{id}", dangerousGoods.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DangerousGoods> dangerousGoodsList = dangerousGoodsRepository.findAll();
        assertThat(dangerousGoodsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DangerousGoods.class);
        DangerousGoods dangerousGoods1 = new DangerousGoods();
        dangerousGoods1.setId(1L);
        DangerousGoods dangerousGoods2 = new DangerousGoods();
        dangerousGoods2.setId(dangerousGoods1.getId());
        assertThat(dangerousGoods1).isEqualTo(dangerousGoods2);
        dangerousGoods2.setId(2L);
        assertThat(dangerousGoods1).isNotEqualTo(dangerousGoods2);
        dangerousGoods1.setId(null);
        assertThat(dangerousGoods1).isNotEqualTo(dangerousGoods2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DangerousGoodsDTO.class);
        DangerousGoodsDTO dangerousGoodsDTO1 = new DangerousGoodsDTO();
        dangerousGoodsDTO1.setId(1L);
        DangerousGoodsDTO dangerousGoodsDTO2 = new DangerousGoodsDTO();
        assertThat(dangerousGoodsDTO1).isNotEqualTo(dangerousGoodsDTO2);
        dangerousGoodsDTO2.setId(dangerousGoodsDTO1.getId());
        assertThat(dangerousGoodsDTO1).isEqualTo(dangerousGoodsDTO2);
        dangerousGoodsDTO2.setId(2L);
        assertThat(dangerousGoodsDTO1).isNotEqualTo(dangerousGoodsDTO2);
        dangerousGoodsDTO1.setId(null);
        assertThat(dangerousGoodsDTO1).isNotEqualTo(dangerousGoodsDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(dangerousGoodsMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(dangerousGoodsMapper.fromId(null)).isNull();
    }
}
