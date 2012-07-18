package pgu.xstream;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.AbstractJsonWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Run {

    public static void main(final String[] args) {

        //        test_1();

        final Person p = new Person().name("toto").age(30);
        p.getChildren().addAll(Arrays.asList( //
                new Person().name("pim").age(10), //
                new Person().name("pam").age(15), //
                new Person().name("poum").age(20) //
                ));

        final XStream xstream_XML = new XStream(new DomDriver());
        xstream_XML.alias("person", Person.class);
        xstream_XML.registerConverter(new PersonConverter());

        System.out.println(xstream_XML.toXML(p));
        System.out.println("");

        //        testJsonHierarchy(p);

        final XStream xstream_JSON_jettison = new XStream(new JettisonMappedXmlDriver());
        xstream_JSON_jettison.setMode(XStream.NO_REFERENCES);
        xstream_JSON_jettison.alias("person", Person.class);

        System.out.println(xstream_JSON_jettison.toXML(p));
        System.out.println("");

    }

    private static void testJsonHierarchy(final Person p) {
        final XStream xstream_JSON_hierar = new XStream(new JsonHierarchicalStreamDriver() {

            @Override
            public HierarchicalStreamWriter createWriter(final Writer writer) {
                return new JsonWriter(writer, AbstractJsonWriter.STRICT_MODE | AbstractJsonWriter.DROP_ROOT_MODE);
            }

        });
        xstream_JSON_hierar.setMode(XStream.NO_REFERENCES);
        xstream_JSON_hierar.alias("person", Person.class);

        System.out.println(xstream_JSON_hierar.toXML(p));
    }

    private static HierarchicalStreamDriver myJsonDriver = new HierarchicalStreamDriver() {

                                                             @Override
                                                             public HierarchicalStreamWriter createWriter(
                                                                     final OutputStream outputStream) {
                                                                 return null;
                                                             }

                                                             @Override
                                                             public HierarchicalStreamWriter createWriter(
                                                                     final Writer writer) {
                                                                 return null;
                                                             }

                                                             @Override
                                                             public HierarchicalStreamReader createReader(
                                                                     final File file) {
                                                                 return null;
                                                             }

                                                             @Override
                                                             public HierarchicalStreamReader createReader(final URL url) {
                                                                 return null;
                                                             }

                                                             @Override
                                                             public HierarchicalStreamReader createReader(
                                                                     final InputStream inputStream) {
                                                                 return null;
                                                             }

                                                             @Override
                                                             public HierarchicalStreamReader createReader(
                                                                     final Reader reader) {
                                                                 return null;
                                                             }
                                                         };

    private static void test_1() {
        final XStream xstream = new XStream();
        xstream.processAnnotations(SerieRep.class);
        xstream.processAnnotations(SeriesRep.class);
        xstream.processAnnotations(TotoRep.class);
        xstream.processAnnotations(TitiRep.class);

        final SerieRep serie1 = new SerieRep();
        serie1.setName("John");
        final SerieRep serie2 = new SerieRep();
        serie2.setName("Jane");
        final SeriesRep series = new SeriesRep();
        series.getEntityReps().add(serie1);
        series.getEntityReps().add(serie2);

        System.out.println(xstream.toXML(serie1));
        System.out.println(xstream.toXML(serie2));
        System.out.println("-------");
        System.out.println(xstream.toXML(series));

        final List<String> ids = new ArrayList<String>();
        ids.add("123");
        ids.add("456");
        ids.add("789");

        System.out.println(String.format("here they are '%s' !", ids));

        int index = 1;

        for (int i = 0; i < 5; i++) {
            System.out.println(index++);
            System.out.println(index);
            System.out.println("--");
        }

        final String xmlToto = "<toto><name>toto!</name></toto>";
        final String xmlTiti = "<titi><reference>titi!</reference></titi>";
        final Object toto = xstream.fromXML(xmlToto);
        final Object titi = xstream.fromXML(xmlTiti);
        System.out.println(toto);
        System.out.println(titi);
    }

}
