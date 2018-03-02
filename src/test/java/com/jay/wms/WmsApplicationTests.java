package com.jay.wms;

import com.jay.wms.dao.DepartmentDao;
import com.jay.wms.dao.UserDao;
import com.jay.wms.entity.Department;
import com.jay.wms.entity.User;
import com.jay.wms.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WmsApplicationTests {


	@Autowired
	DepartmentDao departmentDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		Department department = new Department();
		department.setName("test");
		Integer num = departmentDao.add(department);
		System.out.print("----"+department.toString());
	}
}
