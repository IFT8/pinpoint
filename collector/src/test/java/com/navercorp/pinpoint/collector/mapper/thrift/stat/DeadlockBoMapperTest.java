/*
 * Copyright 2017 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.collector.mapper.thrift.stat;

import com.navercorp.pinpoint.common.server.bo.stat.DeadlockBo;
import com.navercorp.pinpoint.thrift.dto.TDeadlock;
import org.junit.Assert;

/**
 * @author Taejin Koo
 */
public class DeadlockBoMapperTest extends ThriftBoMapperTestBase<TDeadlock, DeadlockBo> {

    private static final int MAX_DEADLOCKED_THREAD_COUNT = 100;

    @Override
    protected TDeadlock create() {
        TDeadlock tDeadlock = new TDeadlock();
        tDeadlock.setDeadlockedThreadCount(getRandomInteger(0, MAX_DEADLOCKED_THREAD_COUNT));

        return tDeadlock;
    }

    @Override
    protected DeadlockBo convert(TDeadlock original) {
        DeadlockBoMapper deadlockBoMapper = new DeadlockBoMapper();
        return deadlockBoMapper.map(original);
    }

    @Override
    protected void verify(TDeadlock original, DeadlockBo mappedStatDataPoint) {
        Assert.assertEquals("deadlockedThreadCount", original.getDeadlockedThreadCount(), mappedStatDataPoint.getDeadlockedThreadCount());
    }

}
