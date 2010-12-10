/*
 * Copyright (C) 2010 Toni Menzel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.repository.base;

import org.ops4j.pax.repository.ArtifactQuery;

/**
 * Simple, un-parsed wrapper of a query.
 */
public class DefaultQuery implements ArtifactQuery
{

    final private String m_query;

    public DefaultQuery( String query )
    {
        m_query = query;
    }

    public String getQueryString()
    {
        return m_query;
    }

    @Override
    public String toString()
    {
        return "[DefaultQuery value=" + m_query + "]";
    }
}
