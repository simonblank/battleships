package com.company.Tests;

import com.company.BattleGrid;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by simon on 03/11/2017.
 */
class BattleGridTest {

    BattleGrid battleGrid= new BattleGrid();

    @BeforeClass
    public void BeforeTest(){
        battleGrid.ClearGrid();


    }


    @org.junit.jupiter.api.Test
    public void TestCollitionDetection(){
        battleGrid.AddShip(3,"horisontal",3,5);


        // test by placing a ship on top another ship  :  collition
        Assert.assertEquals(battleGrid.CheckForShipCollition(3,"horisontal",3,5)
                , true,"no collition");


        // test by colliding a ship on top another ship verticaly  :  collition
        Assert.assertEquals(battleGrid.CheckForShipCollition(5,"vertical",3,1)
                , true,"no collition");


        // test by colliding a ship on top another ship horisontaly : collition
        Assert.assertEquals(battleGrid.CheckForShipCollition(5,"horisontal",1,5)
                , true,"no collition");

        // test by placing ship side by side : no collition
        Assert.assertEquals(battleGrid.CheckForShipCollition(5,"horisontal",2,4)
                , false,"collition");


    }


    @org.junit.jupiter.api.Test
    public void CheckIfTorpedoHit(){
        battleGrid.ClearGrid();
        battleGrid.AddShip(3,"horisontal",3,5);

        /// expect a hit on the ship
        Assert.assertTrue(battleGrid.CheckIfHit(3,5),"shot missed should have hitted1");

        ///shoot ship twice on same place expect a miss
        Assert.assertTrue(!battleGrid.CheckIfHit(3,5),"shot hitted should have missed2");

        /// expect a miss on the ship
        Assert.assertTrue(!battleGrid.CheckIfHit(2,2),"shot hitted should have missed3");

        /// expect a miss on the ship
        Assert.assertTrue(!battleGrid.CheckIfHit(1,1),"shot hitted should have missed4");


    }

    @org.junit.jupiter.api.Test
    public void CheckgridClear(){
        battleGrid.ClearGrid();
        for (int y = 1; y < 11; y++) {
            for (int x = 1; x < 11; x++) {
                Assert.assertEquals(battleGrid.GetEnemyBattleGridTile(x,y),"~","something went wrong with clearing battlegrid");
            }
        }

    }







}