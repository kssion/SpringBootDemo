package com.example.demo;

import com.example.demo.model.DemoModel;
import com.example.demo.service.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private DemoService service;

	@Test
	public void contextLoads() {

        DemoModel model = new DemoModel();
        model.setKey("测试key1");
        model.setValue("测试value1");

        // 记录数
        List<DemoModel> all = service.selectAll();
        int size = all.size();

        // insert
        boolean result = service.insert(model);
        Assert.assertTrue(result);

        // select
        DemoModel selectModel = service.select(model.getId());
        Assert.assertNotNull(selectModel);

        // selectAll
        all = service.selectAll();
        Assert.assertEquals(size + 1, all.size());

        // updateValue
        selectModel.setValue("测试更改value1");
        result = service.updateValue(selectModel);
        Assert.assertTrue(result);

        // delete
        result = service.delete(selectModel.getId());
        Assert.assertTrue(result);
	}
}
