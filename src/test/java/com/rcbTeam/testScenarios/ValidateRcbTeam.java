package com.rcbTeam.testScenarios;
import com.iplTeam.utils.CommonUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ValidateRcbTeam {
    /**
     * Execute before first @Test in the suite
     * Parse the JSON file
     * Load property file
     */
    @BeforeTest
    public void beforeTest(){
        CommonUtils.parseJson("TeamRCB");
        CommonUtils.readPropertiesFile("rcbTeam");
    }

    /**
     * Test script to verify rcb team has only 4 foreign players.
     */
    @Test
    public void verify_foreignPlayerCount(){
        int foreignPlayer_Count = 0;
        List<String> players_country = CommonUtils.readJsonValue(CommonUtils.prop.getProperty("rcb_players_country"));
        for(String eachCountry:players_country)
            if(!eachCountry.equals("India")) foreignPlayer_Count++;
        Assert.assertTrue(foreignPlayer_Count==4);

    }

    /**
     * Test script to verify rcb team has at-least one wicketKeeper.
     */

    @Test
    public void verify_wicketKeeperCount(){
        int wickerKeeper_count=0;
        List<String> roles = CommonUtils.readJsonValue(CommonUtils.prop.getProperty("rcb_players_role"));
        for (String role:roles) if(role.equals("Wicket-keeper")) wickerKeeper_count++;
        Assert.assertTrue(wickerKeeper_count>=1);

    }
}
