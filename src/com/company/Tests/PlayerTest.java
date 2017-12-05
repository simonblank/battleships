package com.company.Tests;

import com.company.Users.Player;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by simon on 03/11/2017.
 */
class PlayerTest {

    Player player = new Player();

    @Test
    public void TesLives(){
        Assert.assertEquals(player.GetLives()
                ,18,"players start lifes are not 18 something is wrong"
        );
    }

    @Test
    public void TestLegalCorrectInputCheck(){

        //legal : check horisontal spelling
        Assert.assertEquals(player.CorrectInputCheck("horisontal",5,1,1)
                ,true , " check horisontal "
        );

        //legal : check vertical spelling
        Assert.assertEquals(player.CorrectInputCheck("vertical",5,1,1)
                ,true , " check vertical "
        );

        //legal : place a 5 ship horisontal at 1,1
        Assert.assertEquals(player.CorrectInputCheck("horisontal",5,1,1)
                ,true , " legal : place a 5 ship horisontal at 1,1 "
        );

        // legal : place a 5 ship horisontal at 1,10
        Assert.assertEquals(player.CorrectInputCheck("horisontal",5,1,10)
                ,true ," legal : place a 5 ship horisontal at 1,10 "
        );

        // legal : place a 5 ship vertical at 1,10
        Assert.assertEquals(player.CorrectInputCheck("vertical",5,1,1)
                ,true , " legal : place a 5 ship vertical at 1,10 "
        );

        // legal : place a 5 ship vertical at 1,10
        Assert.assertEquals(player.CorrectInputCheck("vertical",5,10,1)
                ,true ,"000 legal : place a 5 ship vertical at 1,10 "
        );

        // legal : place a 5 ship horisontal at 6,1
        Assert.assertEquals(player.CorrectInputCheck("horisontal",5,6,1)
                ,true , " legal : place a 5 ship horisontal at 6,1 "
        );

        // legal : place a 5 ship vertical at 1,6
        Assert.assertEquals(player.CorrectInputCheck("vertical",5,1,6)
                ,true ,"000 legal : place a 5 ship vertical at 10,6 "
        );

    }


    @Test
    public void TestIlegalCorrectInputCheck(){

        //illegal : check horisontal spelling
        Assert.assertEquals(player.CorrectInputCheck("horisonaz",5,1,1)
                ,false , " check horisontal spelling"
        );

        //illegal : check vertical
        Assert.assertEquals(player.CorrectInputCheck("verticles",5,1,1)
                ,false , " check vertical spelling"
        );

        //illegal : place a 5 ship horisontal at 0,1 outside of the grid
        Assert.assertEquals(player.CorrectInputCheck("horisontal",5,0,1)
                ,false," illegal : place a 5 ship horisontal at 0,1 outside of the grid "
        );

        // illegal : place a 5 ship horisontal at 1,0 outside of the grid
        Assert.assertEquals(player.CorrectInputCheck("horisontal",5,1,0)
                ,false, " illegal : place a 5 ship horisontal at 1,0 outside of the grid "
        );

        // illegal : place a 5 ship horisontal at 7,1 ship is to big it goes outside the grid
        Assert.assertEquals(player.CorrectInputCheck("horisontal",5,7,1)
                ,false , " illegal : place a 5 ship horisontal at 7,1 outside of the grid "
        );

        // illegal : place a 5 ship horisontal at 1,10
        Assert.assertEquals(player.CorrectInputCheck("vertical",5,1,7)
                ,false , " illegal : place a 5 ship horisontal at 1,7 outside of the grid "
        );


    }







}