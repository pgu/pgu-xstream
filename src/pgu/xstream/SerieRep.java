package pgu.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("serie")
public class SerieRep {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
