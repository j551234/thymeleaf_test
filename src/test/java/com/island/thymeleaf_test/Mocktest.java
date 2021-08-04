package com.island.thymeleaf_test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Mocktest {

    @SpyBean
    private HelloService spyService;
    @Autowired
    private CallService callService;
    /**
     * the same as
     * @Spy private HelloService spyService;
     * @InjectMocks private CallService callService;
     *
     * */

    @Mock
    private List mockList;
    @Spy
    private List spyList = new ArrayList();

    @Mock
    private People peopleInfo;
    @Spy
    private People spyPeople;

    @Test
    void peopleInfoTest() {
        peopleInfo.setName("gg");
        doReturn("gg").when(peopleInfo).getName();
        assert (peopleInfo.getName() != null);
    }

    @Test
    void spyTest() {
        spyPeople.setAge(20);
        when(spyPeople.getName()).thenReturn("eric");
        assert (spyPeople.getAge() == 20);
        assert ("eric".equals(spyPeople.getName()));
    }


    @Test
    public void testMockList() {
        // mock物件是假的, 所以呼叫方法時其實並不會做任何事
        mockList.add("test"); // 並沒有真的把"test"字串加入mockList,
        assert (mockList.get(0) == null);// 如果原方法有返回值, 則mock物件的方法僅返回null
    }

    @Test
    public void testSpyList() {
        // spy物件會呼叫真正的原方法
        spyList.add("test"); // 真的把"test"加入spyList
        Assertions.assertEquals("test", spyList.get(0)); // spy物件的方法會返回值
    }

    @Test
    public void testMockWithStub() {

        String expected = "Mock 100";

        // stub mock物件的get(100)方法
        when(mockList.get(100)).thenReturn(expected);

        Assertions.assertEquals(expected, mockList.get(100));
    }

    @Test
    public void testSpyWithStub() {

        String expected = "Spy 100";
        // stub spy物件的get(100)方法
        // spy物件使用doReturn()來stub方法的返回值
        doReturn(expected).when(spyList).get(100);

        Assertions.assertEquals(expected, spyList.get(100));
    }

    @Test
    void spyServiceTest() {
        spyService.setVersion(999);
        System.out.println(spyService.getVersion());
        assert (spyService.getVersion() == 999);
    }


    @Test
    void setCallService() {
        System.out.println(spyService.sayHello());
        when(spyService.sayHello()).thenReturn("alloha");
        assert (callService.callHello().equals("alloha"));
    }


}

