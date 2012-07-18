package pgu.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("titi")
public class TitiRep implements Child {

    private String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(final String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "TitiRep [reference=" + reference + "]";
    }

}
