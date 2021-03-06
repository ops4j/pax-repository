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
 * Handy Artifact implementation (api helper)
 */
public class ResolvingArtifact implements Artifact
{

    private Artifact m_artifact;

    public ResolvingArtifact( Resolver resolver, ArtifactQuery identifier )
        throws RepositoryException
    {
        m_artifact = resolver.find( identifier );
    }

    public InputStreamSource getContent()
        throws RepositoryException
    {
        return m_artifact.getContent();
    }

}
