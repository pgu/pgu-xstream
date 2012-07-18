package pgu.xstream;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class PersonConverter implements Converter {

    @Override
    public boolean canConvert(final Class clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void marshal(final Object obj, final HierarchicalStreamWriter writer, final MarshallingContext context) {
        final Person person = (Person) obj;

        writer.startNode("fullname");
        writer.setValue(person.getName());
        writer.endNode();
    }

    @Override
    public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext context) {
        final Person p = new Person();

        reader.moveDown();
        p.setName(reader.getValue());
        reader.moveUp();

        return p;
    }

}
