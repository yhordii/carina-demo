/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.regression.dependent;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

/**
 * This sample test DataProvider with retries and it's registration in Zafira.
 * It just generate failure in 50% of cases and on retry should improve statistic
 *
 * @author qpsdemo
 */
public class DependentMethodsTest extends AbstractTest {
	protected static int i = 0;
	protected static int j = 0;

    @MethodOwner(owner = "qpsdemo")
    @Test
    public void testOne() {
    	//Assert.fail("111");
    	if (i==0) {
    		i++;
    		//Assert.fail("111");
    	}
    	
//        boolean isPassed = (new Random().nextInt(2) == 1) ? true : false;
//        Assert.assertTrue(isPassed);
    }
    
    
    @MethodOwner(owner = "qpsdemo")
    @Test(dependsOnMethods="testOne")
    public void testTwo() {
    	Assert.fail("111");
    	if (j==0) {
    		j++;
    		Assert.fail("111");
    	}
    	//do nothing
    }
    

    //todo scenarios to verify
    // testOne - passed from 2nd attempt
    // testTwo - failed
    // -> what about rerun?

}