package tliy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Login.class, CriminalRecord.class, EditingRecord.class, AdminPage.class })
public class AllUnitTests {

}