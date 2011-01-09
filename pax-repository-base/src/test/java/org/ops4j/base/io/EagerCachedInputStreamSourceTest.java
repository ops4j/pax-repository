package org.ops4j.base.io;import java.io.IOException;import java.io.InputStream;import org.junit.Test;import org.ops4j.store.Store;import static org.mockito.Mockito.*;/** * */public class EagerCachedInputStreamSourceTest{    @Test    public void testEagerCachedInputStreamSourceTest()        throws IOException    {        Store<InputStream> store = mock( Store.class );        InputStream input = getSource();        new EagerCachedInputStreamSource( store, input );        // should have fetched resource already!        verify(store,times(1)).store( input );    }    public InputStream getSource()    {        return this.getClass().getResourceAsStream( "/test.txt" );    }}