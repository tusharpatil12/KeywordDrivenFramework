package com.bridgelabz;

import com.bridgelabz.keyword.engine.KeywordDriverFramework;
import org.testng.annotations.Test;

public class loginTest {
    KeywordDriverFramework keywordDriverFramework;

    @Test
    public void loginTest() {
        keywordDriverFramework = new KeywordDriverFramework();
        keywordDriverFramework.starExecution("login");
    }

    @Test
    public void meshLoginTest(){
        keywordDriverFramework = new KeywordDriverFramework();
        keywordDriverFramework.starExecution("meshLogin");
    }

}
