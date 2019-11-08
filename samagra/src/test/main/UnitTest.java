

import org.junit.Assert;
import org.junit.Test;

import service.basic.StaffService;

public class UnitTest {
@Test
public void staffTest() throws Exception {
	
	StaffService ss=new StaffService();
	Assert as;
		//ss.insertStaff(staffDao);
		//staffDao=ss.getAllStaff().get(0);
	
			ss.deleteStaff(2);
			Assert.assertEquals((long)1,(long)ss.getStaffById(2).getActiveInd());
			//assertEquals(1,ss.getStaffById(2).getActiveInd());
		System.out.println("helo");
		//staffDao=ss.getStaffById(1);
	
}
}
