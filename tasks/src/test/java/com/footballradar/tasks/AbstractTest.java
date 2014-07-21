package com.footballradar.tasks;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.footballradar.tasks.technical.ConfigurationContainer;

/**
 * @author hloos
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfigurationContainer.class, loader=AnnotationConfigContextLoader.class)
public abstract class AbstractTest {

	public static final String SCANNED_SERVICE = "com.footballradar.tasks.task1";
	public static final String SCANNED_SERVICE2 = "com.footballradar.tasks.task2";
	public static final String SCANNED_TECHNICAL = "com.footballradar.tasks.technical";

	protected ApplicationContext context = 
	          new AnnotationConfigApplicationContext(SCANNED_SERVICE, SCANNED_SERVICE2, SCANNED_TECHNICAL);
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
}