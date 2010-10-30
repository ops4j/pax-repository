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

import java.io.File;
import org.ops4j.pax.repository.Artifact;
import org.ops4j.pax.repository.ArtifactIdentifier;
import org.ops4j.pax.repository.RepositoryException;
import org.ops4j.pax.repository.RepositoryResolver;

/**
 *
 */
public class FastLocalM2Resolver implements RepositoryResolver
{

    private static final String SEP = "/";

    public Artifact find( ArtifactIdentifier identifier )
        throws RepositoryException
    {
        String group = identifier.getGroupId().replaceAll( "\\.", SEP );
        String local = System.getProperty( "user.home" ) + "/.m2/repository/";
        File f = new File( local + group + SEP + identifier.getArtifactId() + SEP + identifier.getVersion() + SEP + identifier.getArtifactId() + "-" + identifier.getVersion() + "." + identifier.getClassifier() );
        System.out.println( "locating " + f.getAbsolutePath() );
        return new LocalArtifact( identifier, f );
    }
}