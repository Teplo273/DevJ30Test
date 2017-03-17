/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j30server.io.sql.javadbRequest;

import sql.query.queryGenerators.QueryGenerator;
import org.junit.Test;

/**
 *
 * @author kirill
 */
public class JavadbRequestTest {
    
    public JavadbRequestTest() {
    }
    

    /**
     * Test of getInsert method, of class JavadbQueryImpl.
     */
    @Test
    public void testGetInsert_3args() throws Exception {
        System.out.println("getInsert");
        String user = "";
        String table = "dictionary";
        String[] args = {"rus", "eng", "стол", "table"};
        QueryGenerator instance = QueryGenerator.getGenerator();
        //String expResult = "";
        String result = instance.getInsert(table, args);
        //assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
