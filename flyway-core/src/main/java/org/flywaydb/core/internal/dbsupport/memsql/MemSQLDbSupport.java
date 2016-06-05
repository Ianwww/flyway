/**
 * Copyright 2010-2016 Boxfuse GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flywaydb.core.internal.dbsupport.memsql;

import org.flywaydb.core.internal.dbsupport.Schema;
import org.flywaydb.core.internal.dbsupport.mysql.MySQLDbSupport;
import org.flywaydb.core.internal.util.logging.Log;
import org.flywaydb.core.internal.util.logging.LogFactory;

import java.sql.Connection;

/**
 * MemSQL-specific support.
 */
public class MemSQLDbSupport extends MySQLDbSupport {
    private static final Log LOG = LogFactory.getLog(MemSQLDbSupport.class);

    /**
     * Creates a new instance.
     *
     * @param connection The connection to use.
     */
    public MemSQLDbSupport(Connection connection) {
        super(connection);
    }

    @Override
    public String getDbName() {
        return "memsql";
    }

    @Override
    public Schema getSchema(String name) {
        return new MemSQLSchema(jdbcTemplate, this, name);
    }
}