package com.neosoft.springPOC1;

import org.junit.jupiter.api.Test;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Suite.SuiteClasses({SpringPoc1MockitoTest.class, ServicesTest.class})
class SpringPoc1ApplicationTests {

        @Test
        public void mainTest() {
                SpringPoc1Application.main(new String[] {});
        }
}
