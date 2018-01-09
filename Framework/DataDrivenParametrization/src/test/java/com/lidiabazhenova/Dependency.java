package com.lidiabazhenova;

import org.testng.annotations.Test;

import java.io.IOException;

public class Dependency extends TestBase{

    @Test
    public void openingBrowser() throws IOException {
        login();
        System.out.println("browser was opened");
    }


}


