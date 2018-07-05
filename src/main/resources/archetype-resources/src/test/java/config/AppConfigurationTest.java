/**
 * 
 */
package com.hp.daas.daas_delete.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hp.daas.daas_delete.DaasApplication;


/**
 * @author Praveen Malla
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ${app-name}Application.class, initializers = ConfigFileApplicationContextInitializer.class)
@WebAppConfiguration
public class AppConfigurationTest {
	@Autowired
	private AppConfiguration appConfiguration;
	/**
	 * Test method for {@link com.hp.daas.daas_delete.config.DaasConfiguration#isEnabled()}.
	 */
	@Test
	public void testIsEnabled() {
		Assert.assertEquals(true, appConfiguration.isEnabled());
	}

	/**
	 * Test method for {@link com.hp.daas.daas_delete.config.DaasConfiguration#setEnabled(boolean)}.
	 */
	@Test
	public void testGetMessage() {
		Assert.assertEquals("hello world", appConfiguration.getMessage());
	}

}
