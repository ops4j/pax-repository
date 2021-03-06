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
package org.ops4j.pax.repository.spi;

import org.ops4j.pax.repository.Artifact;
import org.ops4j.pax.repository.RepositoryException;

/**
 * Encapsulates
 */
public interface Repository<T>
{

    /**
     * Gives parameter visitor all items that are available in this repository.
     *
     * @param visitor A visitor that collects the data.
     *
     * @throws org.ops4j.pax.repository.RepositoryException In case of a problem.
     */
    void index( IndexVisitor<T> visitor )
        throws RepositoryException;

    /**
     * Retrieve the actual artifact.
     *
     * @param identifier what to load. Got that from a index, presumably.
     *
     * @return The artifact itself.
     * @throws RepositoryException In case of a problem
     */
    Artifact retrieve( T identifier )
        throws RepositoryException;

}
