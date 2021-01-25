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
 * This sample test dependent tests and should produce in Zafira one failure and one skip.
 * Moreover need-rerun flag should be true for both tests
 *
 * @author qpsdemo
 */
public class DependentFailSkipTests extends AbstractTest {

    @MethodOwner(owner = "qpsdemo")
    @Test
    public void testOne() {
    	Assert.fail("Always fail!");
    }
    
    
    @MethodOwner(owner = "qpsdemo")
    @Test(dependsOnMethods="testOne")
    public void testTwo() {
    	//do nothing
    }
    
    //TODO: need verify that both tests have need-rerun=true
    
}