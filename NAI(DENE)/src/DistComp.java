import java.util.Comparator;

 class DistComp implements Comparator<Result> {
    @Override
    public int compare(Result o1, Result o2) {

        return o1.distance <  o2.distance ?  -1 : o1.distance  ==  o2.distance  ? 0 :  1;

    }
}