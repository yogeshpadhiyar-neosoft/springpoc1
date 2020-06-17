package com.neosoft.springPOC1;

import com.neosoft.springPOC1.controller.SpringPoc1MockitoTest;
import com.neosoft.springPOC1.factoryMethod.FactoryPattenTest;
import com.neosoft.springPOC1.model.UserDetailModelTest;
import com.neosoft.springPOC1.service.ServicesTest;
import org.junit.jupiter.api.Test;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Suite.SuiteClasses({SpringPoc1MockitoTest.class, ServicesTest.class, UserDetailModelTest.class, FactoryPattenTest.class})
class SpringPoc1ApplicationTests {

        @Test
        public void mainTest() {
                SpringPoc1Application.main(new String[] {});
        }
}
