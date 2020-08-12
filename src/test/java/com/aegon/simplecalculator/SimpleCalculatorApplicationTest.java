package com.aegon.simplecalculator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.aegon.simplecalculator.controller.SimpleCalculatorController;
import com.aegon.simplecalculator.service.SimpleCalculatorService;
import com.aegon.simplecalculator.service.impl.SimpleCalculatorServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleCalculatorApplicationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        SimpleCalculatorService simpleCalculatorService = applicationContext.getBean(SimpleCalculatorService.class);
        assertTrue(simpleCalculatorService instanceof SimpleCalculatorServiceImpl);

        SimpleCalculatorController simpleCalculatorController = applicationContext.getBean(SimpleCalculatorController.class);
        assertNotNull(simpleCalculatorController);
    }
}