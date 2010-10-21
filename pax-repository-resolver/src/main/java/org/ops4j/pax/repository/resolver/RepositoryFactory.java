/*
 * Copyright (C) 2010 Okidokiteam
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
package org.ops4j.pax.repository.resolver;

import java.util.ArrayList;
import java.util.List;
import org.ops4j.pax.repository.Artifact;
import org.ops4j.pax.repository.ArtifactIdentifier;
import org.ops4j.pax.repository.RepositoryException;
import org.ops4j.pax.repository.RepositoryResolver;

/**
 *
 */
public class RepositoryFactory
{

    public static ArtifactIdentifier parseFromURL( String fullQualifier )
    {

        return new StringToIdentifierParser().parse( fullQualifier );

    }

    public static ArtifactIdentifier identifier( String id, String version, String classifier )
    {

        ArtifactIdentifier artifact = new DefaultArtifactIdentifier( id, version, classifier );
        return artifact;
    }

    public static ArtifactIdentifier identifier( String groupId, String artifactId, String version, String classifier )
    {

        ArtifactIdentifier artifact = new DefaultArtifactIdentifier( groupId, artifactId, version, classifier );
        return artifact;
    }

    public static ArtifactIdentifier parseFromPath( String path )
    {
        return new PathToIdentifierParser().parse( path );
    }

    /**
     * Helper to transform a list of identifiers (in string form) directly into a list of (resolved) artifacts.
     * This one produces readily resolved artifacts (hence: eager)
     *
     * @param repositoryResolver to use for resolving process.
     * @param fullQualifier      qualifier to be resolved.
     *
     * @return This one produces readily resolved artifacts (hence: eager)
     *
     * @throws org.ops4j.pax.repository.RepositoryException
     *          in case of a resolver error (e.g.)
     */
    public static Artifact[] resolveEager( RepositoryResolver repositoryResolver, String... fullQualifier )
        throws RepositoryException
    {
        List<Artifact> list = new ArrayList<Artifact>();
        for( String artifact : fullQualifier )
        {
            list.add( repositoryResolver.find( parseFromURL( artifact ) ) );

        }
        return list.toArray( new Artifact[ list.size() ] );
    }

    /**
     * @param repositoryResolver to use for resolving process.
     * @param fullQualifier      qualifier to be resolved.
     */
    public static Artifact[] resolveLazy( RepositoryResolver repositoryResolver, String... fullQualifier )
        throws RepositoryException
    {
        List<Artifact> list = new ArrayList<Artifact>();
        for( String artifact : fullQualifier )
        {
            list.add( new LazyResolvingArtifact( repositoryResolver, parseFromURL( artifact ) ) );

        }
        return list.toArray( new Artifact[ list.size() ] );
    }


}
