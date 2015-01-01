package ui;

import junit.extensions.abbot.ScriptFixture;

import org.junit.Test;


/**
 * 
 * @author cylong
 * @version 2014年12月30日  下午7:18:23
 */
public class ServerViewTest {

	@Test
	public void testServerView() {
		ScriptFixture script = new ScriptFixture("testconf/SetverViewTest.xml");
		script.run();
	}
}
