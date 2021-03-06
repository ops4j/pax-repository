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
package org.ops4j.pax.repository.base.helpers;

import org.ops4j.base.io.InputStreamSource;
import org.ops4j.pax.repository.Artifact;
import org.ops4j.pax.repository.ArtifactQuery;
import org.ops4j.pax.repository.RepositoryException;
import org.ops4j.pax.repository.Resolver;

/**
 *
 */
public class LazyResolvingSearchResult implements Artifact
{

    final private ArtifactQuery m_artifactIdentifier;
    final private Resolver m_resolver;

    private volatile Artifact m_result;
    private volatile boolean m_failedBefore = false;

    public LazyResolvingSearchResult( Resolver resolver, ArtifactQuery identifier )
        throws RepositoryException
    {
        m_artifactIdentifier = identifier;
        m_resolver = resolver;
    }

    private void lazyResolve()
        throws RepositoryException
    {
        if( m_failedBefore )
        {
            throw new RepositoryException( "Artifact resolve has been failed before. Thus this artifact will not go any better." );
        }

        if( m_result == null )
        {
            try
            {
                m_result = m_resolver.find( m_artifactIdentifier );
            } catch( RepositoryException e )
            {
                m_failedBefore = true;
                throw e; // TODO rethrow safe ?
            }
        }
    }

    public InputStreamSource getContent()
        throws RepositoryException
    {
        lazyResolve();
        return m_result.getContent();
    }
}
