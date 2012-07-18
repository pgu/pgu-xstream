package pgu.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("series")
public class SeriesRep {

    @XStreamImplicit
    private List<SerieRep> reps;

    public List<SerieRep> getEntityReps() {
        if (null == reps) {
            reps = new ArrayList<SerieRep>();
        }
        return reps;
    }

    public void setEntityReps(final List<SerieRep> entityReps) {
        reps = entityReps;
    }

}
