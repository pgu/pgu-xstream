package pgu.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("toto")
public class TotoRep implements Child {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TotoRep [name=" + name + "]";
    }

}
