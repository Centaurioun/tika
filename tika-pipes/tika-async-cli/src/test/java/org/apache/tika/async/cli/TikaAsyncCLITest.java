/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tika.async.cli;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.utils.ProcessUtils;

public class TikaAsyncCLITest {
    @Test
    public void testCrash() throws Exception {
        Path config = getPath("/tika-config-broken.xml");
        assertThrows(TikaConfigException.class,
                () -> TikaAsyncCLI.main(
                        new String[] {
                            ProcessUtils.escapeCommandLine(config.toAbsolutePath().toString())
                        })
        );
    }

    private Path getPath(String file) throws Exception {
        return Paths.get(this.getClass().getResource(file).toURI());
    }
}
