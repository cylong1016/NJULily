package ui.admin;

import junit.extensions.abbot.ScriptFixture;

import org.junit.Test;

/**
 * @author cylong
 * @version 2014年12月30日 下午7:59:25
 */
public class AdminViewTest {

	@Test
	public void testServerView() {
		ScriptFixture script = new ScriptFixture("testconf/AdminViewTest.xml");
		script.run();
	}
}
