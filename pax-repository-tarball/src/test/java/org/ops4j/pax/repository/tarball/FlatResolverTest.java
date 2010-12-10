package org.ops4j.pax.repository.tarball;import java.io.IOException;import java.io.InputStream;import org.junit.Test;import org.ops4j.base.io.InputStreamSource;import org.ops4j.pax.repository.ArtifactQuery;import org.ops4j.pax.repository.RepositoryException;import org.ops4j.pax.repository.Resolver;import org.ops4j.pax.repository.base.DefaultEntry;import org.ops4j.pax.repository.base.DefaultEntryParser;import org.ops4j.pax.repository.base.EmptyFilter;import org.ops4j.pax.repository.maven.GavArtifactQuery;import org.ops4j.pax.repository.maven.GavArtifactQueryParser;import org.ops4j.pax.repository.spi.ArtifactEntry;import org.ops4j.pax.repository.spi.ArtifactFilter;import org.ops4j.pax.repository.spi.EntryParser;import org.ops4j.pax.repository.spi.Repository;import org.ops4j.store.Store;import org.ops4j.store.StoreFactory;import static org.ops4j.pax.repository.base.RepositoryFactory.*;/** * */public class FlatResolverTest{    @Test    public void doit()        throws RepositoryException    {        Store<InputStream> store = StoreFactory.defaultStore();        // the source:        InputStreamSource input = source( getClass().getResourceAsStream( "/gouken-tarball-0.1.0-SNAPSHOT-bin.zip" ) );        ArtifactFilter<ArtifactEntry> filter = new EmptyFilter<ArtifactEntry>( true );        EntryParser<ArtifactEntry> parser = new DefaultEntryParser();        Resolver<GavArtifactQuery> resolver = new FlatResolver(            new TarballRepository<ArtifactEntry>(                input,                filter,                store,                parser            )        );        resolver.find( parse( createQuery( "foo:bar:bee" ) ) );    }    private GavArtifactQuery parse( ArtifactQuery query )    {        return new GavArtifactQueryParser().parse( query );    }    private InputStreamSource source( final InputStream stream )    {        assert stream != null : stream;        return new InputStreamSource()        {            public InputStream get()                throws IOException            {                return stream;            }        };    }}